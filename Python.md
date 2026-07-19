<h1 align="center">Python Cheat Sheet</h1>

## SECTION 0: [PYTHON NOTES](https://github.com/kvinay7/Programming-in-Python)

## SECTION 1: NUMERICAL & CHARACTER METHODS

### Character/String Checks
```python
c.isalpha()              # Is letter
c.isdigit()              # Is digit (0-9)
c.isalnum()              # Is letter or digit
c.isspace()              # Is whitespace
c.isupper()              # Is uppercase
c.islower()              # Is lowercase
c.isascii()              # Is ASCII

# Convert
c.upper()
c.lower()

# Numeric value from char
ord(c) - ord('0')        # Convert '0'-'9' to 0-9
ord(c)                   # Get ASCII value directly
chr(65)                  # 'A' — convert ASCII to char
```

### Math Methods
```python
abs(n)
max(a, b)
min(a, b)
pow(base, exp)           # base^exp
int(n ** 0.5)            # Square root (integer)
import math
math.sqrt(n)             # Float square root
math.floor(x)            # Round down
math.ceil(x)             # Round up
round(x)                 # Round to nearest
math.log(n)              # Natural logarithm
math.log10(n)
math.log(n, base)        # Log with base
```

### Type Conversions
```python
int(str)                 # String to integer
int(str, 16)             # Hex to decimal
int(str, 2)              # Binary to decimal
float(str)               # String to float
bool(str)                # String to boolean

str(n)                   # Integer to string
bin(n)                   # Integer to binary (returns '0b...')
hex(n)                   # Integer to hex (returns '0x...')
oct(n)                   # Integer to octal

# Remove '0b', '0x' prefix
bin(n)[2:]
hex(n)[2:]
```

### Integer Limits & Bitwise
```python
# Python has arbitrary precision (no max int)
import sys
sys.maxsize               # System max int (not really a limit)

# Bitwise operations
n & m                     # AND
n | m                     # OR
n ^ m                     # XOR
~n                        # NOT (invert all bits)
n << k                    # Left shift (multiply by 2^k)
n >> k                    # Right shift (divide by 2^k)

# Bit counting
bin(n).count('1')         # Count 1s in binary
n.bit_length()            # Number of bits needed
```

---

## SECTION 2: I/O & OPERATORS

### Reading Input
```python
# Single line
line = input()                    # Read as string
n = int(input())                  # Read as integer
a, b = map(int, input().split())  # Multiple space-separated

# Multiple lines
lines = []
while True:
    try:
        lines.append(input())
    except EOFError:
        break

# Read from stdin
import sys
lines = sys.stdin.read().strip().split('\n')
```

### Assignment Operators
```python
a += b
a -= b
a *= b
a /= b        # Float division
a //= b       # Integer division
a %= b
a &= b
a |= b
a ^= b
```

### Short-Circuit Operators
```python
result = (a > 0) and (b > 0)  # and — stops if first is False
result = (a > 0) or (b > 0)   # or — stops if first is True
result = not (a > 0)          # not
```

---

## SECTION 3: ARRAYS & LIST METHODS

### List Declaration & Initialization
```python
arr = []                         # Empty list
arr = [0] * n                    # List of n zeros
arr = [i for i in range(n)]      # List [0, 1, ..., n-1]
arr = [[0] * m for _ in range(n)]  # 2D list (n x m)
arr = [1, 2, 3]                  # Direct initialization
```

### List Manipulation
```python
arr.append(x)                    # Add to end
arr.insert(i, x)                 # Insert at index
arr.extend([x, y, z])            # Add multiple
arr.pop()                        # Remove last, return it
arr.pop(i)                       # Remove at index, return it
arr.remove(x)                    # Remove first occurrence
arr.clear()                      # Remove all
arr.index(x)                     # First index of x (-1 if not found using arr.index(x) will raise ValueError)

arr.reverse()                    # In-place reverse
arr.sort()                       # In-place sort
arr.sort(reverse=True)           # Descending
arr.sort(key=lambda x: x[1])     # Sort by second element

len(arr)
arr[i]
arr[i:j]                         # Slice [i, j)
arr[::-1]                        # Reverse (creates new list)
x in arr                         # Check membership
arr.count(x)                     # Count occurrences

# Convert between list and array
import array
int_array = array.array('i', [1, 2, 3])  # 'i' = signed integer
```

### Common Operations
```python
sum(arr)
min(arr)
max(arr)
all(arr)                         # All truthy?
any(arr)                         # Any truthy?

# Create copy
new_arr = arr.copy()
new_arr = arr[:]
new_arr = list(arr)

# enumerate()
arr = [10, 20, 30]
for i, x in enumerate(arr):
    print(i, x)

# zip()
a = [1, 2]
b = [3, 4]
for x, y in zip(a, b):
    print(x, y)

# sorted() - returns new list
sorted(arr)
sorted(arr, reverse=True)

# reversed()
for x in reversed(arr):
    print(x)

# List comprehension
arr = [x*x for x in range(5)]

# Nested comprehension
matrix = [[0 for _ in range(m)] for _ in range(n)]

# Copy vs Alias
a = [1,2,3]
b = a          # Alias
c = a.copy()   # Copy
d = a[:]       # Copy
```

---

## SECTION 4: STRING & MANIPULATION

### String Methods
```python
len(s)
s[i]                             # Character at index
s[i:j]                           # Substring [i, j)
s.find(substr)                   # First occurrence (-1 if not found)
s.rfind(substr)                  # Last occurrence
s.startswith(prefix)
s.endswith(suffix)
s.count(substr)                  # Count occurrences
s.replace(old, new)              # Returns new string
s.split(delimiter)               # Returns list
s.join(list)                     # Join list elements
s.strip()                        # Remove leading/trailing whitespace
s.lstrip()                       # Remove leading
s.rstrip()                       # Remove trailing
s.upper()
s.lower()
s.capitalize()                   # First char uppercase
s.title()                        # Capitalize each word
s.isdigit()                      # All digits?
s.isalpha()                      # All letters?
s.isalnum()                      # All alphanumeric?
s.isspace()                      # All whitespace?

# Character array
list(s)                          # String to list of chars
''.join(list)                    # List of chars to string
```

### List vs Strings (Mutable vs Immutable)
```python
# Strings are immutable — use list
s = "abc"
chars = list(s)
chars[0] = 'x'
s = ''.join(chars)  # "xbc"

# Or use bytearray (mutable)
b = bytearray(b"abc")
b[0] = ord('x')
s = b.decode()
```

---

## SECTION 5: COLLECTIONS & DATA STRUCTURES

### List (Dynamic Array)
```python
list = []
list.append(x)
list.pop()                       # Remove last
list.pop(i)                      # Remove at index
list[i]
list.insert(i, x)
list.remove(x)                   # Remove first occurrence
list.clear()
len(list)
```

### Set (Unordered, No Duplicates)
```python
s = set()                        # Empty set
s = {1, 2, 3}                    # Direct initialization
s.add(x)
s.remove(x)                      # Raises KeyError if not found
s.discard(x)                     # No error if not found
s.pop()                          # Remove arbitrary element
s.clear()
x in s
len(s)

# Set operations
s.union(other)                   # | operator
s.intersection(other)            # & operator
s.difference(other)              # - operator
s.symmetric_difference(other)    # ^ operator
s.update(other)                  # Add all from other
s.intersection_update(other)     # Keep only common
s.difference_update(other)       # Remove common
```

### Dictionary (HashMap)
```python
d = {}                           # Empty dict
d = {1: 'a', 2: 'b'}            # Direct
d[key] = value
d.get(key)                       # Returns None if not found
d.get(key, default)              # Returns default if not found
d.pop(key)                       # Remove and return
d.pop(key, default)
d.setdefault(key, default)       # Get or set if not exists
d.update(other)                  # Merge dicts
d.clear()

key in d                         # Check key
d.keys()                         # All keys
d.values()                       # All values
d.items()                        # All (key, value) pairs
len(d)

# Frequency counting (CRITICAL PATTERN)
from collections import Counter
freq = Counter(arr)              # Count occurrences
freq[x]                          # Get frequency
freq.most_common()
freq.most_common(k)              # Top k elements
list(freq.elements())
```

### DefaultDict (Auto-initialize)
```python
from collections import defaultdict
d = defaultdict(list)            # Default value = empty list
d = defaultdict(int)             # Default value = 0
d[key].append(x)                 # No KeyError
```

### Stack (LIFO)
```python
stack = []
stack.append(x)                  # Push
stack.pop()                      # Pop (remove last)
stack[-1]                        # Peek (last element)
len(stack)
not stack                        # Check if empty
```

### Queue (FIFO)
```python
from collections import deque
q = deque()
q.append(x)                      # Add to rear
q.popleft()                      # Remove from front
q[0]                             # Peek front
len(q)
not q                            # Check if empty
```

### Deque (Double-Ended Queue)
```python
from collections import deque
d = deque()
d.append(x)                      # Add to right
d.appendleft(x)                  # Add to left
d.pop()                          # Remove from right
d.popleft()                      # Remove from left
d[0]                             # Peek left
d[-1]                            # Peek right
d.rotate(k)                      # Rotate right by k
d.extend(iterable)
d.extendleft(iterable)
d.rotate(k)
d.rotate(-k)
```

### Heap (Priority Queue)
```python
import heapq
heap = []
heapq.heappush(heap, x)          # Add (min-heap)
heapq.heappop(heap)              # Remove min
heap[0]                          # Peek min
heapq.heapify(list)              # Convert list to heap (in-place)

# Max heap (negate values)
heapq.heappush(heap, -x)
-heapq.heappop(heap)

# Or use tuple (priority, value)
heapq.heappush(heap, (priority, value))

# k largest/smallest
heapq.nlargest(k, list)
heapq.nsmallest(k, list)

heapq.heapreplace(heap, x)
heapq.heappushpop(heap, x)
```

### OrderedDict (Maintains insertion order)
```python
from collections import OrderedDict
d = OrderedDict()
d[key] = value
# In Python 3.7+, regular dict maintains order
```

### Sorted Container (Advanced)
```python
from sortedcontainers import SortedList
sl = SortedList()
sl.add(x)
sl.remove(x)
sl.pop()
sl.pop(0)                        # Remove first
sl[0]                            # Min element
sl[-1]                           # Max element
len(sl)
```

