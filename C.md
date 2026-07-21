# C & Data Structures — GATE CS/IT & DA

## SECTION 1: BASICS & DATA TYPES

### Basic Structure of C
- Preprocessor Directive → Global Variables → main() → Local Variables, Statements → Functions

### Preprocessor Directives

**Macro Replacement (#define)**
- Function-like macro: `#define MAX(a,b) ((a)>(b)?(a):(b))`
- Object-like macro: `#define PI 3.14`

**#undef Directive**
- Undefine a macro: `#undef MACRO_NAME`

**#ifdef, #ifndef, #else, #endif**
- Conditional compilation directives

**#line Directive**
- Line number tracking: `#line number "file name"`

**#error Directive**
- Print error message to stderr

**#pragma Directive**
- Special compiler commands

---

### Data Types

**Primary/Scalar/Basic Types**
- Arithmetic: char, int, float, double
- Derived: arrays, pointers, structures, unions
- Enum, Void

**Type Qualifiers**
- `const`: value cannot be modified after definition
- `volatile`: value can be changed externally

**Type Casting** — Conversion of one data type to another (forced conversion)
- Values may be temporarily truncated (especially float → int)

---

### Data Type Sizes (16-bit Computer)

| Data Type | Size (bytes) | Format |
|-----------|-------------|--------|
| char | 1 | %c |
| signed char | 1 | %c or %hhi |
| unsigned char | 1 | %c or %hhu |
| short int | 2 | %hd, %hi |
| signed short int | 2 | %hi |
| unsigned short int | 2 | %hu |
| int | 2 | %d, %i |
| signed int | 2 | %i |
| unsigned int | 2 | %u |
| long int | 4 | %ld |
| signed long int | 4 | %li |
| unsigned long int | 4 | %lu |
| long long int | 8 | %lld |
| signed long long int | 8 | %lli |
| unsigned long long int | 8 | %llu |
| float | 4 | %f |
| double | 8 | %Lf |
| long double | 10 | %LF |

**Architecture Note:** 
- 32-bit systems: int = 4 bytes, long int = 4 bytes
- 64-bit systems: int = 4 bytes, long int = 8 bytes
- Pointer size: 4 bytes on 32-bit, 8 bytes on 64-bit (not fixed)

**Other Format Specifiers**
- `%d` — Decimal
- `%o` — Octal
- `%x` (or) `%X` — Hexadecimal
- `%e` — Exponent
- `%s` — String

---

### Data Type Ranges

| Type | Range |
|------|-------|
| Signed int (n-bit) | [-2^(n-1) to 2^(n-1)-1] |
| Unsigned int (n-bit) | [0 to 2^n-1] |
| float | [3.4E-38 to 3.4E+38] |
| double | [1.7E-308 to 1.7E+308] |
| long double | [3.4E-4932 to 1.1E+4932] |

**Boolean**
- Data type: `bool (0 or 1)`
- Size: 1 byte (in most systems)
- Range: No mathematical range

---

## SECTION 2: I/O & OPERATORS

### Input/Output Functions

**Formatted Functions (stdio.h)**
```c
scanf("format specifiers", &variable-name);
printf("format specifiers", variable-name);
```

**Escape Sequences**
- `\a` — Alert/bell
- `\b` — Backspace
- `\f` — Form feed
- `\n` — New line
- `\r` — Carriage return
- `\t` — Horizontal tab
- `\v` — Vertical tab
- `\'` — Single quote
- `\"` — Double quote
- `\\` — Backslash
- `\0` — Null
- `\000` — Octal number
- `\hh` — Hexadecimal number

**Printing Integers**
```c
printf("%d", 2486);              // Basic integer
printf("%5d", 2486);             // Right-justified in field width 5
printf("%05d", 2486);            // Zero-padded
printf("%-5d", 2486);            // Left-justified
```

**Printing Real Numbers**
```c
printf("%f", 98.7144);           // Default precision (6 decimal places)
printf("%.2f", 98.7144);         // 2 decimal places
printf("%8.2f", 98.7144);        // Field width 8, 2 decimal places
printf("%-8.2f", 98.7144);       // Left-justified, field width 8, 2 decimals
```

**Unformatted Input Functions (stdio.h)**
- `getchar()`: read single character from input stream
- `getch()`, `getche()`: non-standard; avoid for portable code
- `fgets(string, size, stdin)`: read line from input (safer than `gets()`)

**Unformatted Output Functions**
- `putchar(ch)`: output single character
- `puts(string)`: output string followed by newline
- `printf()`: formatted output (already covered)

**Command Line Arguments**
- `argc`: integer count of command line arguments
- `argv[]`: array of pointers to strings (char* argv[])
- Example: `./program arg1 arg2` → argc=3, argv={"./program", "arg1", "arg2"}

---

## SECTION 3: OPERATORS

### I. Arithmetic Operators
`[+, -, *, /, %]`

**Modulo Division**
- Sign of result in modulo division follows the sign of the first operand
- `(-10) % 3 = -1` (not +1)

### II. Logical Operators
`[&&, ||, !]`

**Truth Table**

| A | B | A && B | A \|\| B | !A |
|---|---|--------|----------|-----|
| 1 | 1 | 1 | 1 | 0 |
| 1 | 0 | 0 | 1 | 0 |
| 0 | 1 | 0 | 1 | 1 |
| 0 | 0 | 0 | 0 | 1 |

**Short-Circuit Behavior**
- `&&`: Stops evaluation if first operand is false
- `||`: Stops evaluation if first operand is true

### III. Bitwise Operators
`[&, |, ^, ~, <<, >>]`

**Bitwise AND, OR, XOR**
```
A & B  → 1 only if both are 1
A | B  → 1 if either is 1
A ^ B  → 1 if exactly one is 1
```

**Bitwise NOT (~)**
- Inverts all bits: `~n = -(n+1)` (2's complement)
- Example: `~10 = -11`

**Bitwise Shifts**
- `n << k`: Left shift by k positions (multiply by 2^k)
- `n >> k`: Right shift by k positions (divide by 2^k for unsigned)

---

### IV. Assignment Operators
`[=, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=]`

### V. Relational Operators
`[>, <, <=, >=, ==, !=]`

### VI. Special Operators
`[(,), [,], ., ->, *, &, sizeof()]`

### VII. Increment/Decrement Operators
`[++, --]`

- `++i` (pre-increment): Increment first, then use value
- `i++` (post-increment): Use value first, then increment
- `--i` (pre-decrement): Decrement first, then use value
- `i--` (post-decrement): Use value first, then decrement

**Difference exists only in assignment contexts:**
```c
a = ++i;  // Increment then assign
a = i++;  // Assign then increment
```

### VIII. Ternary/Conditional Operator
`<expression1> ? <expression2> : <expression3>`

---

## SECTION 4: OPERATOR PRECEDENCE & ASSOCIATIVITY

| Precedence | Operator | Description | Associativity |
|---|---|---|---|
| **1 (Highest)** | `()` `[]` `.` `->` | Function call, array subscript, member access | Left to Right |
| **2** | `++` `--` `+` `-` `!` `~` `(type)` `*` `&` `sizeof()` | Unary operators, typecast, dereference, address, size | Right to Left |
| **3** | `*` `/` `%` | Multiplication, division, modulo | Left to Right |
| **4** | `+` `-` | Addition, subtraction | Left to Right |
| **5** | `<<` `>>` | Bitwise shifts | Left to Right |
| **6** | `<` `<=` `>` `>=` | Relational operators | Left to Right |
| **7** | `==` `!=` | Equality operators | Left to Right |
| **8** | `&` | Bitwise AND | Left to Right |
| **9** | `^` | Bitwise XOR | Left to Right |
| **10** | `\|` | Bitwise OR | Left to Right |
| **11** | `&&` | Logical AND | Left to Right |
| **12** | `\|\|` | Logical OR | Left to Right |
| **13** | `?:` | Conditional (ternary) operator | Right to Left |
| **14** | `=` `+=` `-=` `*=` `/=` `%=` `&=` `\|=` `^=` `<<=` `>>=` | Assignment operators | Right to Left |
| **15 (Lowest)** | `,` | Comma operator | Left to Right |

---

## SECTION 5: CONTROL STATEMENTS

### Conditional / Decision Making Statements

**(i) if statement**
```c
if (condition)
    statement;
```

**(ii) if-else statement**
```c
if (condition)
    statement1;
else
    statement2;
```

**(iii) else-if statements**
```c
if (condition1)
    statement1;
else if (condition2)
    statement2;
else
    statement3;
```

**(iv) Switch statement**
```c
switch (value)
{
    case 1:
        statement1;
        break;
    case 2:
        statement2;
        break;
    default:
        statement;
}
```

---

### Iterative / Looping Statements

**(i) while loop**
```c
initialization;
while (condition)
{
    body;
    update;
}
```

**(ii) do-while loop**
```c
initialization;
do
{
    body;
    update;
} while (condition);
```

**(iii) for loop**
```c
for (initialization; condition; update)
{
    body;
}
```

**(iv) Nested loops** — Loops within loops for multi-dimensional iteration

---

### Unconditional / Jumping Statements

**(i) goto statement**
- Forward jumping: `goto label;`
- Backward jumping: `label: ... goto label;`

**(ii) continue statement**
- Skips rest of current iteration, jumps to loop update

**(iii) break statement**
- Exits innermost loop or switch immediately

**(iv) exit() function**
- Terminates entire program

**(v) return statement**
- Returns control to calling function (or OS if in main)

---

## SECTION 6: STORAGE CLASSES

| Storage Class | Memory Location | Initial Value | Scope | Lifetime |
|---|---|---|---|---|
| **auto** | Primary memory | Garbage (uninitialized) | Within block | End of block |
| **extern** | Primary memory | Zero | Global | Till end of program |
| **static** | Primary memory | Zero | Within block (or global) | Till end of program |
| **register** | CPU register | Garbage | Within block | End of block |

**Storage Class Details**
- `auto`: Default for local variables; automatically deallocated
- `extern`: Declaration linking across files; enables external linkage
- `static`: Limits scope to file; persistent across function calls
- `register`: Compiler hint to store in register (rarely enforced)

---

## SECTION 7: FUNCTIONS

### Function Definition

```c
return_type function_name(parameter_list)
{
    statements;
    return (expression);
}
```

**Function Basics**
- In modern C (C99+), return type must be explicitly specified
- Default behavior (implicit int) is not standard; avoid relying on it
- Functions are the main building blocks of C programs

### Function Calls

**Call by Value:**
- Actual parameters passed by value; changes inside function don't affect caller

**Call by Reference:**
- Actual parameters passed by address; changes inside function affect caller

### Recursion

**Direct Recursion:**
```c
function1()
{
    statement;
    function1();  // Calls itself
}
```

**Indirect Recursion:**
```c
function1()
{
    statement;
    function2();
}
function2()
{
    statement;
    function1();
}
```

**Recursion Execution**
- Uses system stack (LIFO order)
- Each recursive call creates new stack frame
- Base case required to prevent infinite recursion

---

## SECTION 8: ARRAYS

### Declaration & Initialization

```c
datatype array_name[size];
```

**Array Basics**
- Collection of similar data types stored in contiguous memory
- Each element accessed via index (starting from 0)
- Static memory allocation (size fixed at compile-time)
- Array name acts as pointer to first element

**Initialization Rules**
- Static arrays (outside functions): Auto-initialized to 0
- Extern arrays: Cannot be initialized
- Local auto arrays: Contain garbage values if not initialized
- Global/static arrays: All elements set to 0 by default

---

### Array Size Calculation

**Single Dimension Array**
```
Total Size = sizeof(datatype) × length
```

**Multi-Dimensional Arrays**
```c
int arr[3][4];  // 3 rows, 4 columns
```

---

### Row-Major & Column-Major Address Calculation

**Row-Major (C/C++ Standard)**
- Elements stored row by row
- Address of `arr[i][j]` in array `arr[m][n]`:
  ```
  Address = Base_Address + (i × n + j) × sizeof(element)
  ```
- Example: `arr[2][3]` in `arr[5][4]`
  ```
  Address = Base + (2 × 4 + 3) × 4 = Base + 44 bytes
  ```

**Column-Major (Fortran/MATLAB Standard)**
- Elements stored column by column
- Address of `arr[i][j]` in array `arr[m][n]`:
  ```
  Address = Base_Address + (j × m + i) × sizeof(element)
  ```

---

### Array Passing to Functions

- When array passed as argument, base address (pointer) is passed
- Size must be passed separately or assumed
- Array declaration in function parameter: `void fun(int arr[])` or `void fun(int *arr)`

---

## SECTION 9: POINTERS

### Pointer Basics

```c
datatype *pointer_name;
```

**Pointer Fundamentals**
- Pointer holds memory address of another variable/function
- Pointer size: 4 bytes (32-bit system), 8 bytes (64-bit system)
- Memory allocation for pointer depends on data type being pointed to

**Pointer Operators**
- `&` (address-of): Get address of variable
- `*` (dereference): Access value at address

---

### Array of Pointers

```c
datatype *array_name[size];
```

**Example:**
```c
int *p[5];      // Array of 5 pointers to int
char *str[10];  // Array of 10 pointers to char
```

---

### Pointer Arithmetic

```
new_address = current_address ± (k × sizeof(datatype))
```

**Examples:**
```c
int *p = arr;  // p points to arr[0]
p++;           // p now points to arr[1] (address increases by 4 bytes on 32-bit)
p += 2;        // p now points to arr[3]
p--;           // p now points to arr[2]
```

---

### Pointer to Function

```c
return_type (*ptr_name)(argument_types);
```

**Example:**
```c
int (*fp)(int, int);      // Pointer to function taking 2 ints, returning int
fp = &add;                // Point to add function
result = (*fp)(5, 10);    // Call via pointer
```

---

### Void Pointer

- Generic pointer; can point to any data type
- Cannot be dereferenced directly; must be cast
- Used for generic memory operations (malloc, memcpy, etc.)

---

## SECTION 10: STRINGS

### String Declaration

```c
char str[size];       // Character array (null-terminated)
char *str;            // Pointer to string
```

**String Basics**
- Strings are character arrays terminated by null character `\0`
- String length is number of characters excluding null terminator
- Limited only by available memory and array allocation
- Arrays of strings: `char str[n][max_length]`

---

### Standard String Functions (string.h)

| Function | Prototype | Description |
|----------|-----------|-------------|
| **strlen** | `size_t strlen(const char *s)` | Return length of string |
| **strcpy** | `char *strcpy(char *dest, const char *src)` | Copy string (unsafe) |
| **strncpy** | `char *strncpy(char *dest, const char *src, int n)` | Copy n characters |
| **strcmp** | `int strcmp(const char *s1, const char *s2)` | Compare strings |
| **strcat** | `char *strcat(char *dest, const char *src)` | Concatenate strings |
| **strncat** | `char *strncat(char *dest, const char *src, int n)` | Concatenate n characters |
| **strchr** | `char *strchr(const char *s, int c)` | Find first occurrence of character |
| **strstr** | `char *strstr(const char *s1, const char *s2)` | Find substring |
| **strspn** | `size_t strspn(const char *s1, const char *s2)` | Length of prefix matching |
| **strcspn** | `size_t strcspn(const char *s1, const char *s2)` | Length of prefix not matching |

---

### Character Conversion (stdlib.h)

| Function | Prototype | Description |
|----------|-----------|-------------|
| **atoi** | `int atoi(const char *s)` | String to integer |
| **atof** | `float atof(const char *s)` | String to float |
| **atol** | `long atol(const char *s)` | String to long integer |

---

### Dynamic Memory Allocation

**Memory Allocation Functions**

| Function | Prototype | Purpose |
|----------|-----------|---------|
| **malloc** | `ptr = (type*) malloc(size)` | Allocate memory; uninitialized |
| **calloc** | `ptr = (type*) calloc(n, size)` | Allocate n elements; zero-initialized |
| **realloc** | `ptr = (type*) realloc(ptr, new_size)` | Resize allocated memory |
| **free** | `free(ptr)` | Deallocate memory; set ptr to NULL |

**Example:**
```c
int *arr = (int*) malloc(10 * sizeof(int));
if (arr == NULL) { /* handle error */ }
free(arr);
arr = NULL;  // Best practice
```

---

## SECTION 11: FILE HANDLING

### File I/O Functions (stdio.h)

**File Operations**

| Function | Prototype | Description |
|----------|-----------|-------------|
| **fopen** | `FILE *fopen(const char *filename, const char *mode)` | Open file |
| **fclose** | `int fclose(FILE *fp)` | Close file |
| **fread** | `size_t fread(void *ptr, size_t size, size_t nmemb, FILE *fp)` | Read from file |
| **fwrite** | `size_t fwrite(const void *ptr, size_t size, size_t nmemb, FILE *fp)` | Write to file |
| **fprintf** | `int fprintf(FILE *fp, const char *format, ...)` | Formatted write to file |
| **fscanf** | `int fscanf(FILE *fp, const char *format, ...)` | Formatted read from file |

**File Modes**
- `"r"`: Read (file must exist)
- `"w"`: Write (creates/truncates file)
- `"a"`: Append (creates if doesn't exist)
- `"r+"`: Read + Write (file must exist)
- `"w+"`: Read + Write (creates/truncates)
- `"a+"`: Read + Append (creates if doesn't exist)

---

### File Positioning

| Function | Prototype | Description |
|----------|-----------|-------------|
| **fseek** | `int fseek(FILE *fp, long offset, int position)` | Seek to position |
| **ftell** | `long ftell(FILE *fp)` | Get current position |
| **rewind** | `void rewind(FILE *fp)` | Seek to beginning |

**Seek Positions**
- `SEEK_SET`: Beginning of file
- `SEEK_CUR`: Current position
- `SEEK_END`: End of file

---

### Error Handling

| Function | Purpose |
|----------|---------|
| **feof(FILE *fp)** | Check end-of-file |
| **ferror(FILE *fp)** | Check for read/write error |
| **clearerr(FILE *fp)** | Clear error flags |

---

## SECTION 12: STRUCTURES & UNIONS

### Structures

```c
struct struct_name
{
    datatype member1;
    datatype member2;
    ...
};
```

**Structure Basics**
- Collection of heterogeneous data elements
- Memory allocated individually for each member
- Accessed via dot operator (.) or arrow operator (->)

**Nested Structures:**
```c
struct Address
{
    char street[50];
    int zipcode;
};

struct Employee
{
    char name[50];
    struct Address addr;  // Nested structure
};
```

---

### Structure Padding & Memory Alignment

**Memory Alignment**
- Compiler aligns structure members for efficient access
- Padding bytes added between members if needed
- Total size may be > sum of member sizes

**Example:**
```c
struct Example
{
    char c;      // 1 byte, offset 0
    // 3 bytes padding
    int i;       // 4 bytes, offset 4
    double d;    // 8 bytes, offset 8
};
sizeof(Example) = 16 bytes (not 13)
```

**Alignment Rules**
- Each member aligned to its size (char=1, int=4, double=8, etc.)
- Structure size typically multiple of largest member size

---

### Unions

```c
union union_name
{
    datatype member1;
    datatype member2;
    ...
};
```

**Union Basics**
- Similar to structure, but members share same memory
- Only one member can hold value at a time
- Size equals size of largest member
- All members mapped to same memory location

**Example:**
```c
union Data
{
    int i;      // 4 bytes
    float f;    // 4 bytes
    char c;     // 1 byte
};
sizeof(Data) = 4 bytes (largest member)
```

---

### Enums

```c
enum enum_name { value1, value2, ..., valueN };
```

**Enum Basics**
- Symbolic names for integer constants
- Values assigned sequentially (0, 1, 2, ...) by default
- Can assign explicit values

**Example:**
```c
enum Color { RED = 0, GREEN = 1, BLUE = 2 };
enum Days { MON, TUE, WED, THU, FRI };  // MON=0, TUE=1, etc.
```

---

## SECTION 13: DATA STRUCTURES

### Stacks

**Stack Operations (LIFO — Last In First Out)**

```c
push(element)      // Add to top (if TOP=N-1, overflow)
pop()              // Remove from top (if TOP=-1, underflow)
peek()             // View top element
size()             // Number of elements
isEmpty()          // Check if empty
isFull()           // Check if full
display()          // Print all elements
```

**Initialization:** `TOP = -1`

**Stack Applications**
- Function call stack (recursion)
- Expression evaluation (infix → postfix)
- Postfix expression evaluation
- Balanced parenthesis checking
- Undo/Redo functionality
- Backtracking (DFS)

**Time Complexity**
- Push: O(1)
- Pop: O(1)
- Search: O(n)

---

### Queues

**Queue Operations (FIFO — First In First Out)**

```c
enqueue(element)   // Add to rear (if R=N-1, overflow)
dequeue()          // Remove from front (if F=-1, underflow)
front()            // View front element
rear()             // View rear element
isEmpty()          // Check if empty
isFull()           // Check if full
display()          // Print all elements
```

**Queue Applications**
- CPU scheduling
- Disk scheduling
- Printer queue
- BFS (breadth-first search)
- Level-order tree traversal

**Time Complexity**
- Enqueue: O(1)
- Dequeue: O(1)
- Search: O(n)

---

### Circular Queue

**Concept**
- When rear reaches end, wrap around to front if space available
- Efficient use of array space
- Front and rear pointers circular

**Operations**
- Enqueue: Check if `(rear + 1) % n == front` (full)
- Dequeue: Check if `front == -1` (empty)

---

### Double Ended Queue (Deque)

**Deque Basics**
- Insertion and deletion at both ends
- Can function as stack or queue

**Types**
- Input-restricted deque: Insertion at one end only
- Output-restricted deque: Deletion from one end only

---

### Priority Queue

**Priority Queue Concept**
- Elements served based on priority (not FIFO/LIFO)
- Higher priority elements dequeued first
- Same-priority elements served in queue order

**Implementation**
- Array with linear search: O(n) enqueue, O(1) dequeue
- Heap: O(log n) enqueue, O(log n) dequeue

---

### Linked Lists

**Singly Linked List**
- Forward traversal only
- Each node has data and link to next node

**Doubly Linked List**
- Forward and backward traversal possible
- Each node has data, previous link, next link

**Circular Linked List**
- Last node points to first node
- No NULL pointer

**Operations**
- Creation, Traversal, Insertion, Deletion, Searching

**Advantages over Arrays**
- Dynamic size (no fixed allocation)
- Efficient insertion/deletion (no shifting needed)
- No memory waste from pre-allocation

---

### Hash Tables

**Hash Table Basics**
- Key-value pairs mapped via hash function
- Fast average-case O(1) lookup
- Handles collisions via probing or chaining

**Hash Function**
- Maps key to array index
- Good hash function: uniform distribution, minimal collisions
- Common methods: modulo, folding, mid-square

**Collision Resolution Techniques**

**1. Open Addressing (Probing)**
- Linear Probing: `h(k, i) = (h(k) + i) mod m`
  - Probe `h(k), h(k)+1, h(k)+2, ...`
  - Problem: Clustering
  
- Quadratic Probing: `h(k, i) = (h(k) + i²) mod m`
  - Reduces clustering
  
- Double Hashing: `h(k, i) = (h(k) + i × h2(k)) mod m`
  - Uses secondary hash function
  - Better distribution

**2. Chaining**
- Each bucket contains linked list of colliding elements
- Separate chain for each hash value

**Load Factor:** `α = n / m` (elements / table size)
- Performance degrades as α increases
- Typically rehash when α > 0.75

**Time Complexity**

| Operation | Average | Worst |
|-----------|---------|-------|
| Search | O(1) | O(n) |
| Insert | O(1) | O(n) |
| Delete | O(1) | O(n) |

---

## SECTION 14: TREES & GRAPHS

### Tree Basics

**Tree Terminology**
- **Node:** Individual element
- **Edge:** Connection between nodes
- **Root:** Top node (no parent)
- **Leaf:** Node with no children
- **Height:** Maximum distance from root to leaf
- **Depth:** Distance from root to a specific node
- **Degree:** Number of children
- **Level:** Rank in hierarchy

**Tree Properties**
- For n nodes: n-1 edges
- Connected acyclic graph

---

### Binary Trees

**Binary Tree Basics**
- Each node has at most 2 children (left and right)
- Can be empty (unlike general trees)

**Binary Tree Properties**
- Max nodes at level k: 2^k
- Max nodes in tree of height h: 2^(h+1) - 1
- Min height for n nodes: ⌈log₂(n+1)⌉ - 1
- Max height for n nodes: n - 1

**Types of Binary Trees**

**1. Full Binary Tree**
- Every node has 0 or 2 children
- Nodes: n = 2^(h+1) - 1

**2. Complete Binary Tree**
- All levels filled except possibly last
- Last level filled left to right
- Used in heap implementation

**3. Balanced Binary Tree**
- Height difference ≤ 1 between subtrees
- Improves search efficiency

**4. Perfect Binary Tree**
- All leaves at same level
  
---

### Binary Search Tree (BST)

**BST Property**
- Left subtree values < node value
- Right subtree values > node value
- Inorder traversal gives sorted sequence

**BST Operations**
- Search: O(log n) average, O(n) worst (skewed)
- Insert: O(log n) average, O(n) worst
- Delete: O(log n) average, O(n) worst

**Traversal Methods**
- **Inorder** (L-R-P): Left, Node, Right → Sorted output
- **Preorder** (P-L-R): Node, Left, Right → Tree copy
- **Postorder** (L-P-R): Left, Right, Node → Tree deletion

---

### AVL Trees (Self-Balancing BST)

**AVL Basics**
- Self-balancing binary search tree
- Balance factor: height(left) - height(right) ∈ {-1, 0, 1}
- Automatically rebalances on insert/delete

**Rotations**
- Single Right Rotation
- Single Left Rotation
- Left-Right Rotation
- Right-Left Rotation

**Time Complexity**
- Search, Insert, Delete: O(log n) guaranteed
- Height: 1.44 × log₂(n) (more balanced than unbalanced BST)

---

### Graph Basics

**Graph Representation**
- **Adjacency Matrix:** O(V²) space, O(1) edge lookup
- **Adjacency List:** O(V+E) space, O(degree) edge lookup

**Graph Traversal**
- **BFS (Breadth-First Search):** O(V+E), uses queue
- **DFS (Depth-First Search):** O(V+E), uses stack/recursion

**Shortest Path Algorithms**
- **Dijkstra:** O((V+E) log V) with min-heap, non-negative weights
- **Bellman-Ford:** O(VE), handles negative weights

**Minimum Spanning Tree**
- **Kruskal:** O(E log E), edges sorted first
- **Prim:** O((V+E) log V), vertex-based

---

## SECTION 15: TIME & SPACE COMPLEXITY

### Data Structure Complexity Table

| Data Structure | Access | Search | Insert | Delete | Space |
|---|---|---|---|---|---|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Singly LL | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Doubly LL | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Hash Table | N/A | O(1) avg, O(n) worst | O(1) avg, O(n) worst | O(1) avg, O(n) worst | O(n) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) | O(n) |
| BST | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(n) |
| AVL Tree | O(logn) | O(logn) | O(logn) | O(logn) | O(n) |

**Note:** *O(1) for insertion/deletion at known position; O(n) if position must be found

---

### Sorting Algorithm Complexity

| Algorithm | Best | Average | Worst | Space | Stable |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Merge Sort | O(nlogn) | O(nlogn) | O(nlogn) | O(n) | Yes |
| Quick Sort | O(nlogn) | O(nlogn) | O(n²) | O(logn) | No |
| Heap Sort | O(nlogn) | O(nlogn) | O(nlogn) | O(1) | No |
| Counting Sort | O(n+k) | O(n+k) | O(n+k) | O(k) | Yes |
| Radix Sort | O(nk) | O(nk) | O(nk) | O(n+k) | Yes |

**k:** Range of input (for counting/radix sort)

