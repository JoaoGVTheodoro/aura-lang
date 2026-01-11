value = 10
nullable = 'hello'
coalesced = (nullable if nullable is not None else 'default')
result = ('big' if (value > 5) else 'small')
def safe_div(a, b):
    if (b == 0):
            return None
    return (a / b)
try:
    x = safe_div(10, 0)
except Exception:
    error = 'Division failed'
finally:
    cleanup = 'done'
