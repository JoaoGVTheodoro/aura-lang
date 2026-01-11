"""Aura Standard Library - Collections module."""

def list_from(*items):
    """Create a list from items."""
    return list(items)

def list_map(fn, items):
    """Map function over list."""
    return list(map(fn, items))

def list_filter(predicate, items):
    """Filter list by predicate."""
    return list(filter(predicate, items))

def list_reduce(fn, items, initial=None):
    """Reduce list to single value."""
    from functools import reduce
    if initial is not None:
        return reduce(fn, items, initial)
    return reduce(fn, items)

def list_find(predicate, items):
    """Find first item matching predicate."""
    for item in items:
        if predicate(item):
            return item
    return None

def list_any(predicate, items):
    """Check if any item matches predicate."""
    return any(predicate(item) for item in items)

def list_all(predicate, items):
    """Check if all items match predicate."""
    return all(predicate(item) for item in items)

def list_take(n, items):
    """Take first n items."""
    return list(items[:n])

def list_drop(n, items):
    """Drop first n items."""
    return list(items[n:])

def list_zip(*iterables):
    """Zip lists together."""
    return list(zip(*iterables))

def list_flatten(items):
    """Flatten nested list."""
    result = []
    for item in items:
        if isinstance(item, (list, tuple)):
            result.extend(list_flatten(item))
        else:
            result.append(item)
    return result

def list_unique(items):
    """Get unique items preserving order."""
    seen = set()
    result = []
    for item in items:
        if item not in seen:
            seen.add(item)
            result.append(item)
    return result

def list_sort(items, key=None, reverse=False):
    """Sort list."""
    return sorted(items, key=key, reverse=reverse)

def list_reverse(items):
    """Reverse list."""
    return list(reversed(items))

def list_chunk(n, items):
    """Split list into chunks of size n."""
    return [list(items)[i:i+n] for i in range(0, len(items), n)]

def dict_from(**kwargs):
    """Create dict from keyword arguments."""
    return dict(kwargs)

def dict_get(d, key, default=None):
    """Get dict value with default."""
    return d.get(key, default)

def dict_keys(d):
    """Get dict keys as list."""
    return list(d.keys())

def dict_values(d):
    """Get dict values as list."""
    return list(d.values())

def dict_items(d):
    """Get dict items as list."""
    return list(d.items())

def dict_merge(*dicts):
    """Merge multiple dicts."""
    result = {}
    for d in dicts:
        result.update(d)
    return result

def dict_filter(predicate, d):
    """Filter dict by predicate."""
    return {k: v for k, v in d.items() if predicate(k, v)}

def dict_map(fn, d):
    """Map function over dict values."""
    return {k: fn(v) for k, v in d.items()}

def set_from(*items):
    """Create set from items."""
    return set(items)

def set_union(*sets):
    """Union of sets."""
    result = set()
    for s in sets:
        result = result.union(s)
    return result

def set_intersection(*sets):
    """Intersection of sets."""
    result = sets[0] if sets else set()
    for s in sets[1:]:
        result = result.intersection(s)
    return result

def set_difference(a, *rest):
    """Difference of sets."""
    result = a.copy()
    for s in rest:
        result = result.difference(s)
    return result

# Aliases for convenience
map_list = list_map
filter_list = list_filter
reduce_list = list_reduce
find_in_list = list_find
