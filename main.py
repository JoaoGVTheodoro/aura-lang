"""CLI entry for Aura transpiler (Phase 2 scaffold).

Provides a minimal `transpile` command that uses the simple
`parser.to_ast` converter and the Phase 1 transformer to emit Python.
"""
import argparse
import sys
from parser.to_ast import parse_file
from transpiler.transformer import Transformer


def cmd_transpile(path: str) -> int:
    try:
        ast = parse_file(path)
    except FileNotFoundError:
        print(f"File not found: {path}", file=sys.stderr)
        return 2

    t = Transformer()
    out = t.transform(ast)
    print(out)
    return 0


def main(argv=None):
    argv = argv or sys.argv[1:]
    p = argparse.ArgumentParser(prog='aura')
    sub = p.add_subparsers(dest='cmd')

    transp = sub.add_parser('transpile', help='Transpile an Aura file to Python-like code')
    transp.add_argument('path', help='Source file (.aura)')

    args = p.parse_args(argv)
    if args.cmd == 'transpile':
        return cmd_transpile(args.path)

    p.print_help()
    return 1


if __name__ == '__main__':
    raise SystemExit(main())