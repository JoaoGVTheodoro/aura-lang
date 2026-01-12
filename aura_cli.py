#!/usr/bin/env python3
import sys
import argparse
from pathlib import Path

# Fix path to include project root
sys.path.insert(0, str(Path(__file__).parent))

from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

def run_file(path, debug=False):
    """Run an Aura source file."""
    with open(path, 'r') as f:
        code = f.read()
    
    try:
        if debug: print(f"[DEBUG] Parsing {path}...")
        tokenizer = Tokenizer(code)
        tokens = tokenizer.tokenize()
        parser = Parser(tokens)
        ast = parser.parse()
        
        if debug: print(f"[DEBUG] AST Node: {ast}")
        
        if debug: print(f"[DEBUG] Transpiling...")
        transformer = Transformer()
        py_code = transformer.transform(ast)
        
        if debug: 
            print("--- Python Code ---")
            print(py_code)
            print("-------------------")
            
        exec(py_code, {'__name__': '__main__'})
        
    except Exception as e:
        print(f"Error: {e}")
        if debug: raise

def start_repl():
    """Start the interactive REPL."""
    from repl.engine import AuraREPL
    repl = AuraREPL()
    repl.run()

def main():
    parser = argparse.ArgumentParser(description="Aura Programming Language CLI")
    subparsers = parser.add_subparsers(dest='command', help='Command to execute')
    
    # Run command
    run_parser = subparsers.add_parser('run', help='Run an Aura file')
    run_parser.add_argument('file', help='Path to .aura file')
    run_parser.add_argument('--debug', action='store_true', help='Enable debug output')
    
    # REPL command
    subparsers.add_parser('repl', help='Start interactive REPL')
    
    args = parser.parse_args()
    
    if args.command == 'run':
        run_file(args.file, args.debug)
    elif args.command == 'repl' or args.command is None:
        start_repl()
    else:
        parser.print_help()

if __name__ == "__main__":
    main()
