<h1 align="center">Java Cheat Sheet</h1>

## SECTION 0: [JAVA NOTES](https://github.com/kvinay7/interview-preparation/blob/main/Java.md)

## SECTION 1: NUMERICAL & CHARACTER METHODS

### Character Class
```
Character.isLetter(c)           // Is letter
Character.isDigit(c)            // Is digit (0-9)
Character.isLetterOrDigit(c)    // Is letter or digit
Character.isWhitespace(c)       // Is whitespace
Character.isUpperCase(c)        // Is uppercase
Character.isLowerCase(c)        // Is lowercase
Character.toUpperCase(c)        // Convert to uppercase
Character.toLowerCase(c)        // Convert to lowercase
Character.getNumericValue(c)    // Convert '0'-'9' to 0-9
```

### Math Methods
```
Math.abs(n)                     // Absolute value
Math.max(a, b)                  // Maximum
Math.min(a, b)                  // Minimum
Math.pow(base, exp)             // base^exp
Math.sqrt(n)                    // Square root
Math.floor(x)                   // Round down
Math.ceil(x)                    // Round up
Math.round(x)                   // Round to nearest integer
Math.log(n)                     // Natural logarithm
Math.log10(n)                   // Base 10 logarithm
```

### Type Conversions
```
Integer.parseInt(str)           // String to int
Integer.parseInt(str, 16)       // Hex string to int
Integer.parseInt(str, 2)        // Binary string to int
Long.parseLong(str)             // String to long
Double.parseDouble(str)         // String to double
Boolean.parseBoolean(str)       // "true" -> true, else false

String.valueOf(n)               // Better than toString()
Integer.toBinaryString(n)       // int to binary string
Integer.toHexString(n)          // int to hex string
Integer.toOctalString(n)        // int to octal string
Integer.bitCount(n)             // Count 1s in binary
```

### Integer Limits
```
Integer.MAX_VALUE               // 2147483647
Integer.MIN_VALUE               // -2147483648
Long.MAX_VALUE                  // 9223372036854775807
Long.MIN_VALUE                  // -9223372036854775808

Integer.numberOfLeadingZeros(n)     // Count leading zeros
Integer.numberOfTrailingZeros(n)    // Count trailing zeros
```

---

## SECTION 2: I/O & OPERATORS

### Fast I/O (MANDATORY for interviews)
```
import java.io.*;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine();                    // Read entire line
int n = Integer.parseInt(br.readLine());        // Read single integer

StringTokenizer st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken());       // Parse first token
int b = Integer.parseInt(st.nextToken());       // Parse second token

int[] arr = new int[n];
st = new StringTokenizer(br.readLine());
for(int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(st.nextToken());
}

System.out.println(result);                     // Output
br.close();
```

### Bitwise Operators
```
a & b           // AND
a | b           // OR
a ^ b           // XOR
~a              // NOT (bitwise complement)
a << n          // Left shift (multiply by 2^n)
a >> n          // Right shift (divide by 2^n)
a >>> n         // Unsigned right shift
```

### Assignment Operators
```
a += b;         // Add and assign
a -= b;         // Subtract and assign
a *= b;         // Multiply and assign
a /= b;         // Divide and assign
a %= b;         // Modulo and assign
a &= b;         // AND and assign
a |= b;         // OR and assign
a ^= b;         // XOR and assign
a <<= n;        // Left shift and assign
a >>= n;        // Right shift and assign
```

### Short-Circuit Operators
```
(a > 0) && (b > 0)              // AND — stops if first is false
(a > 0) || (b > 0)              // OR — stops if first is true
!condition                      // NOT
```

---

## SECTION 3: ARRAYS & ARRAY METHODS

### Array Declaration & Initialization
```
int[] arr = new int[n];         // Initialize with zeros
int[] arr = {1, 2, 3};          // Direct initialization
Integer[] arr = new Integer[n]; // Object array (nullable)
int[][] matrix = new int[m][n]; // 2D array (m x n)
```

### Array Manipulation
```
System.arraycopy(src, srcPos, dest, destPos, length);    // Copy array
Arrays.fill(arr, value);                                  // Fill entire array
Arrays.fill(arr, start, end, value);                      // Fill range
Arrays.sort(arr);                                         // Sort ascending
Arrays.sort(arr, Collections.reverseOrder());             // Sort descending
Arrays.binarySearch(arr, key);                            // Binary search (array must be sorted)
Arrays.equals(arr1, arr2);                                // Compare arrays
Arrays.copyOf(arr, length);                               // Copy array
Arrays.stream(arr).sum();                                 // Stream sum
Arrays.stream(arr).max();                                 // Stream max
Arrays.stream(arr).min();                                 // Stream min

Integer[] arr = list.toArray(new Integer[0]);             // List to Array
List<Integer> list = new ArrayList<>(Arrays.asList(arr)); // Array to List
```

### Matrix Operations
```
matrix.length               // Number of rows
matrix[0].length            // Number of columns

// Column-wise iteration
for(int j = 0; j < cols; j++) {
    for(int i = 0; i < rows; i++) {
        // matrix[i][j]
    }
}

// Row-wise iteration
for(int i = 0; i < rows; i++) {
    for(int j = 0; j < cols; j++) {
        // matrix[i][j]
    }
}
```

---

## SECTION 4: STRING & STRINGBUILDER

### String Methods
```
s.length()                          // Length of string
s.charAt(i)                         // Character at index i
s.substring(i)                      // From i to end
s.substring(i, j)                   // From i to j (j exclusive)
s.indexOf(str)                      // First occurrence (-1 if not found)
s.lastIndexOf(str)                  // Last occurrence
s.contains(str)                     // Boolean check
s.toCharArray()                     // String to char array
s.equals(other)                     // Exact equality
s.equalsIgnoreCase(other)           // Case-insensitive equality
s.startsWith(prefix)                // Boolean check
s.endsWith(suffix)                  // Boolean check
s.split(delimiter)                  // Returns String[]
s.trim()                            // Remove leading/trailing spaces
s.replaceAll(regex, replacement)    // Replace using regex
s.replace(oldChar, newChar)         // Simple character replacement
s.toUpperCase()                     // Convert to uppercase
s.toLowerCase()                     // Convert to lowercase
s.concat(str)                       // Returns new concatenated string
s.compareTo(other)                  // Lexicographic comparison (0 if equal)
s.compareToIgnoreCase(other)        // Case-insensitive comparison
```

### StringBuilder Methods
```
StringBuilder sb = new StringBuilder(str);      // Initialize with String
sb.append(char/int/string);                    // Append
sb.insert(index, value);                       // Insert at position
sb.replace(start, end, str);                   // Replace range
sb.reverse();                                  // Reverse (in-place)
sb.deleteCharAt(i);                            // Delete character at i
sb.delete(start, end);                         // Delete range [start, end)
sb.length();                                   // Length of StringBuilder
sb.setCharAt(i, c);                            // Set character at index
sb.toString();                                 // Convert to String
```

### String vs StringBuilder (CRITICAL)
```
// Strings are IMMUTABLE — use StringBuilder for loops
String s = "abc";
s = s + "d";        // Creates new String object

// StringBuilder — MUTABLE
StringBuilder sb = new StringBuilder("abc");
sb.append("d");     // Modifies in-place
String result = sb.toString();
```

---

## SECTION 5: COLLECTIONS FRAMEWORK

### ArrayList (Dynamic Array)
```
List<Integer> list = new ArrayList<>();
list.add(x);                        // Add to end
list.add(index, x);                 // Insert at position
list.get(i);                        // Get element at i
list.set(i, value);                 // Replace element at i
list.remove(i);                     // Remove at index i
list.remove(obj);                   // Remove first occurrence of obj
list.contains(x);                   // Boolean check
list.size();                        // Size of list
list.clear();                       // Remove all elements
list.indexOf(x);                    // First index of x (-1 if not found)
Collections.sort(list);             // Sort in-place
Collections.sort(list, Collections.reverseOrder());  // Descending
list.sort((a, b) -> a - b);         // Custom comparator (ascending)
list.sort((a, b) -> b - a);         // Custom comparator (descending)
Collections.reverse(list);          // Reverse in-place
Collections.swap(list, i, j);       // Swap elements
```

### HashSet (Unordered, No Duplicates)
```
Set<Integer> set = new HashSet<>();
set.add(x);                         // Add
set.remove(x);                      // Remove
set.contains(x);                    // Boolean check
set.size();                         // Size
set.isEmpty();                      // Check if empty
set.clear();                        // Remove all

// Set operations
set.addAll(other);                  // Union
set.retainAll(other);               // Intersection
set.removeAll(other);               // Difference
```

### LinkedHashSet (Preserves Insertion Order)
```
Set<Integer> set = new LinkedHashSet<>();
// Same methods as HashSet, but maintains insertion order
```

### TreeSet (Sorted, No Duplicates)
```
Set<Integer> set = new TreeSet<>();
// Sorted ascending by default
Set<Integer> set = new TreeSet<>(Collections.reverseOrder());  // Descending
set.first();                        // Get minimum
set.last();                         // Get maximum
set.lower(x);                       // Largest element < x
set.higher(x);                      // Smallest element > x
```

### HashMap (Key-Value Pairs)
```
Map<Integer, Integer> map = new HashMap<>();
map.put(key, value);                // Add key-value pair
map.putIfAbsent(key, value);        // Only if key doesn't exist
map.get(key);                       // Returns value or null
map.getOrDefault(key, defaultValue); // Returns default if key not found
map.remove(key);                    // Remove key-value pair
map.containsKey(key);               // Check if key exists
map.containsValue(value);           // Check if value exists
map.keySet();                       // Get all keys (Set)
map.values();                       // Get all values (Collection)
map.entrySet();                     // Get all key-value pairs
map.size();                         // Number of key-value pairs
map.isEmpty();                      // Check if empty
map.clear();                        // Remove all

// Iteration (FASTEST: entrySet)
for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();
}

// Frequency counting (CRITICAL PATTERN)
map.put(x, map.getOrDefault(x, 0) + 1);
```

### LinkedHashMap (Preserves Insertion Order)
```
Map<Integer, Integer> map = new LinkedHashMap<>();
// Same methods as HashMap, but maintains insertion order
```

### TreeMap (Sorted by Key)
```
Map<Integer, Integer> map = new TreeMap<>();
// Keys are sorted in ascending order
map.firstKey();                     // Get minimum key
map.lastKey();                      // Get maximum key
map.lowerKey(key);                  // Largest key < given key
map.higherKey(key);                 // Smallest key > given key
```

### Stack (LIFO — Last In First Out)
```
Stack<Integer> stack = new Stack<>();
stack.push(x);                      // Add to top
stack.pop();                        // Remove and return top
stack.peek();                       // Return top without removing
stack.isEmpty();                    // Check if empty
stack.size();                       // Size of stack
stack.search(x);                    // Returns position from top (1-based)
```

### Queue (FIFO — First In First Out)
```
Queue<Integer> q = new LinkedList<>();
q.offer(x);                         // Add to rear (returns boolean)
q.add(x);                           // Add to rear (throws exception if full)
q.poll();                           // Remove and return front (returns null if empty)
q.remove();                         // Remove and return front (throws exception)
q.peek();                           // Return front without removing
q.element();                        // Return front (throws exception if empty)
q.isEmpty();                        // Check if empty
q.size();                           // Size of queue
```

### Deque (Double-Ended Queue)
```
Deque<Integer> deque = new LinkedList<>();
deque.addFirst(x);                  // Add to front
deque.addLast(x);                   // Add to rear
deque.removeFirst();                // Remove from front
deque.removeLast();                 // Remove from rear
deque.getFirst();                   // Get front (throws exception if empty)
deque.getLast();                    // Get rear (throws exception if empty)
deque.peekFirst();                  // Peek front
deque.peekLast();                   // Peek rear
deque.pollFirst();                  // Remove and return front
deque.pollLast();                   // Remove and return rear
```

### PriorityQueue (Min-Heap by Default)
```
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(x);                   // Add element
minHeap.poll();                     // Remove and return minimum
minHeap.peek();                     // Return minimum without removing
minHeap.isEmpty();                  // Check if empty
minHeap.size();                     // Size of heap

// Max-Heap (negate or custom comparator)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
maxHeap.offer(x);                   // Add element
maxHeap.poll();                     // Remove and return maximum

// Custom comparator
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
    if(a.value != b.value) return Integer.compare(a.value, b.value);
    return a.id.compareTo(b.id);
});
```

---

## SECTION 6: COMPARATOR & SORTING

### Custom Comparator
```
// For Arrays
Arrays.sort(arr, (a, b) -> Integer.compare(a.value, b.value));  // Ascending
Arrays.sort(arr, (a, b) -> Integer.compare(b.value, a.value));  // Descending

// For Lists
Collections.sort(list, (a, b) -> Integer.compare(a.value, b.value));

// Multi-level sorting
Arrays.sort(arr, (a, b) -> {
    if(a.value != b.value) return Integer.compare(a.value, b.value);
    return a.id.compareTo(b.id);  // Secondary sort by id
});

// String sorting
String[] strs = {...};
Arrays.sort(strs);                  // Ascending
Arrays.sort(strs, Collections.reverseOrder());  // Descending
```

### Comparable vs Comparator
```
// Comparable (implement in class)
class Pair implements Comparable<Pair> {
    public int compareTo(Pair other) {
        return this.value - other.value;
    }
}
Collections.sort(list);             // Uses compareTo()

// Comparator (external sorting)
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.value - b.value;
    }
}
Collections.sort(list, new PairComparator());

// Lambda (modern approach)
Collections.sort(list, (a, b) -> a.value - b.value);
```

