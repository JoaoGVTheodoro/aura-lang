"""Simple macro registry scaffold for Phase 2."""
from typing import Callable

class MacroRegistry:
    def __init__(self):
        self._macros = {}

    def register(self, name: str, fn: Callable):
        self._macros[name] = fn

    def expand(self, name: str, *args, **kwargs):
        fn = self._macros.get(name)
        if not fn:
            raise KeyError(f"Macro {name} not found")
        return fn(*args, **kwargs)

# global registry
registry = MacroRegistry()

# example: debug macro (placeholder)
def debug_macro(fn_src: str):
    # This would transform source; for now, just wrap with prints
    return f"print(\"[DEBUG] entering macro\");\n{fn_src}\nprint(\"[DEBUG] exiting macro\")\n"

registry.register('debug', debug_macro)
