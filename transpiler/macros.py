"""Comprehensive macro and decorator system for Aura."""
from typing import Callable, Dict, List, Any, Optional
from dataclasses import dataclass
import re

# ============================================================================
# Macro & Decorator AST
# ============================================================================

@dataclass
class Decorator:
    """Representation of a decorator."""
    name: str
    arguments: List[str] = None
    
    def __post_init__(self):
        if self.arguments is None:
            self.arguments = []

# ============================================================================
# Macro Definitions
# ============================================================================

class Macro:
    """Base class for macros."""
    
    def __init__(self, name: str, fn: Callable = None):
        self.name = name
        self.fn = fn
    
    def expand(self, *args, **kwargs) -> str:
        """Expand macro with given arguments."""
        if self.fn:
            return self.fn(*args, **kwargs)
        raise NotImplementedError(f"Macro {self.name} not implemented")

# ============================================================================
# Built-in Macros
# ============================================================================

class DebugMacro(Macro):
    """@debug decorator - add debug logging to functions."""
    
    def __init__(self):
        super().__init__('debug')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Add debug prints around function."""
        indent = "    "
        return f"""def {func_name}(*args, **kwargs):
{indent}print(f"DEBUG: Entering {func_name} with args={{args}}, kwargs={{kwargs}}")
{indent}try:
{indent}{indent}result = ({func_code})
{indent}{indent}print(f"DEBUG: Exiting {func_name} with result={{result}}")
{indent}{indent}return result
{indent}except Exception as e:
{indent}{indent}print(f"DEBUG: Exception in {func_name}: {{e}}")
{indent}{indent}raise"""

class TimeItMacro(Macro):
    """@timeit decorator - measure function execution time."""
    
    def __init__(self):
        super().__init__('timeit')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Add timing measurement."""
        indent = "    "
        return f"""import time
def {func_name}(*args, **kwargs):
{indent}start = time.time()
{indent}try:
{indent}{indent}result = ({func_code})
{indent}{indent}return result
{indent}finally:
{indent}{indent}elapsed = time.time() - start
{indent}{indent}print(f"{{func_name}} took {{elapsed:.4f}}s")"""

class MemoizeMacro(Macro):
    """@memoize decorator - cache function results."""
    
    def __init__(self):
        super().__init__('memoize')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Add memoization."""
        indent = "    "
        return f"""def {func_name}(*args, **kwargs):
{indent}cache = getattr({func_name}, '_cache', {{}})
{indent}key = (args, tuple(sorted(kwargs.items())))
{indent}if key in cache:
{indent}{indent}return cache[key]
{indent}result = ({func_code})
{indent}cache[key] = result
{indent}{func_name}._cache = cache
{indent}return result"""

class PropertyMacro(Macro):
    """@property decorator - Python property."""
    
    def __init__(self):
        super().__init__('property')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Make function a property."""
        return f"@property\ndef {func_name}(self):\n    {func_code}"

class StaticMethodMacro(Macro):
    """@staticmethod decorator - static method."""
    
    def __init__(self):
        super().__init__('staticmethod')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Make function static."""
        return f"@staticmethod\ndef {func_name}(*args, **kwargs):\n    {func_code}"

class ClassMethodMacro(Macro):
    """@classmethod decorator - class method."""
    
    def __init__(self):
        super().__init__('classmethod')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Make function class method."""
        return f"@classmethod\ndef {func_name}(cls, *args, **kwargs):\n    {func_code}"

class CacheMacro(Macro):
    """@cache decorator - LRU cache."""
    
    def __init__(self):
        super().__init__('cache')
    
    def expand(self, func_name: str, func_code: str, maxsize: int = 128) -> str:
        """Add LRU caching."""
        return f"@functools.lru_cache(maxsize={maxsize})\ndef {func_name}(*args, **kwargs):\n    {func_code}"

class MustReturnMacro(Macro):
    """@must_return decorator - ensure function returns value."""
    
    def __init__(self):
        super().__init__('must_return')
    
    def expand(self, func_name: str, func_code: str) -> str:
        """Validate return value."""
        indent = "    "
        return f"""def {func_name}(*args, **kwargs):
{indent}result = ({func_code})
{indent}if result is None:
{indent}{indent}raise ValueError(f"{{func_name}} must return a value")
{indent}return result"""

# ============================================================================
# Macro Registry
# ============================================================================

class MacroRegistry:
    """Registry of all available macros."""
    
    def __init__(self):
        self._macros: Dict[str, Macro] = {}
        self._register_builtins()
    
    def _register_builtins(self):
        """Register built-in macros."""
        self.register(DebugMacro())
        self.register(TimeItMacro())
        self.register(MemoizeMacro())
        self.register(PropertyMacro())
        self.register(StaticMethodMacro())
        self.register(ClassMethodMacro())
        self.register(CacheMacro())
        self.register(MustReturnMacro())
    
    def register(self, macro: Macro):
        """Register a macro."""
        self._macros[macro.name] = macro
    
    def expand(self, name: str, *args, **kwargs) -> str:
        """Expand a macro."""
        macro = self._macros.get(name)
        if not macro:
            raise KeyError(f"Macro '{name}' not found")
        return macro.expand(*args, **kwargs)
    
    def has_macro(self, name: str) -> bool:
        """Check if macro exists."""
        return name in self._macros
    
    def list_macros(self) -> List[str]:
        """List all available macros."""
        return list(self._macros.keys())
    
    def get_macro(self, name: str) -> Optional[Macro]:
        """Get macro object."""
        return self._macros.get(name)

# ============================================================================
# Decorator Parser
# ============================================================================

class DecoratorParser:
    """Parse decorators from source code."""
    
    @staticmethod
    def parse_decorators(source: str) -> List[Decorator]:
        """Extract decorators from source."""
        decorators = []
        # Match @decorator_name(args) or @decorator_name
        pattern = r'@(\w+)(?:\((.*?)\))?'
        
        for match in re.finditer(pattern, source):
            name = match.group(1)
            args_str = match.group(2) or ""
            args = [arg.strip() for arg in args_str.split(',')] if args_str else []
            decorators.append(Decorator(name, args))
        
        return decorators
    
    @staticmethod
    def remove_decorators(source: str) -> str:
        """Remove decorators from source."""
        lines = source.split('\n')
        result = []
        
        for line in lines:
            if not line.strip().startswith('@'):
                result.append(line)
        
        return '\n'.join(result)

# ============================================================================
# Macro Expander
# ============================================================================

class MacroExpander:
    """Expand decorators/macros in code."""
    
    def __init__(self, registry: MacroRegistry = None):
        self.registry = registry or MacroRegistry()
        self.parser = DecoratorParser()
    
    def expand(self, source: str) -> str:
        """Expand all macros in source."""
        decorators = self.parser.parse_decorators(source)
        code = self.parser.remove_decorators(source)
        
        # Apply decorators in reverse order
        for decorator in reversed(decorators):
            if self.registry.has_macro(decorator.name):
                # Extract function name and body
                func_match = re.search(r'fn\s+(\w+)\s*\((.*?)\)\s*\{(.*?)\}', code, re.DOTALL)
                if func_match:
                    func_name = func_match.group(1)
                    func_body = func_match.group(3).strip()
                    
                    # Expand macro
                    expanded = self.registry.expand(
                        decorator.name,
                        func_name,
                        func_body,
                        *decorator.arguments
                    )
                    code = expanded
        
        return code

# ============================================================================
# Global Instances
# ============================================================================

registry = MacroRegistry()
expander = MacroExpander(registry)
