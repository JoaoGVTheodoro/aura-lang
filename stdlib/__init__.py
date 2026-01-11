"""Aura Standard Library initialization."""

__version__ = "0.1.0"
__author__ = "Aura Team"

# Core modules
from . import collections
from . import itertools
from . import math
from . import string

# Common exports
__all__ = [
    'collections',
    'itertools',
    'math',
    'string',
]

# Convenience imports
from .collections import (
    list_map,
    list_filter,
    list_reduce,
    dict_get,
    dict_keys,
    dict_values,
    set_union,
    set_intersection,
)

from .itertools import (
    range_iter,
    chain,
    combinations,
    permutations,
    enumerate_iter,
)

from .math import (
    PI, E, TAU,
    sqrt, pow, exp,
    sin, cos, tan,
    log, log10,
)

from .string import (
    upper, lower, trim,
    split, join, replace,
    starts_with, ends_with,
)
