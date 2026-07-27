<h1 align="center">Programming in C & Data Structures</h1>

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

**Example**

```c
// Single dimension
int arr[5] = {1, 2, 3, 4, 5};
int arr2[] = {10, 20, 30};      // Size inferred: 3

// Multi-dimensional (row-major storage)
int matrix[3][4] = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// Accessing elements
printf("%d\n", arr[0]);         // 1
printf("%d\n", matrix[1][2]);   // 7

// Array name as pointer
int *ptr = arr;                 // ptr points to arr[0]
printf("%d\n", *(ptr + 1));     // Same as arr[1]
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

**Example**

```c
int x = 10;
int *ptr = &x;              // ptr holds address of x

printf("%d\n", x);          // 10
printf("%d\n", *ptr);       // 10 (dereference)
printf("%p\n", &x);         // Address of x
printf("%p\n", ptr);        // Same address
printf("%lu\n", sizeof(ptr)); // 8 bytes (64-bit system)
```

---

### Array of Pointers

```c
datatype *array_name[size];
```

**Example:**
```c
int a = 10, b = 20, c = 30;
int *ptrs[3] = {&a, &b, &c};   // Array of 3 pointers to int

printf("%d\n", *ptrs[0]);       // 10
printf("%d\n", *ptrs[1]);       // 20

// Pointer to array (different)
int arr[5] = {1, 2, 3, 4, 5};
int (*ptr_arr)[5] = &arr;       // Pointer to array of 5 ints
printf("%d\n", (*ptr_arr)[2]);  // 3
```

---

### Pointer Arithmetic

```
new_address = current_address ± (k × sizeof(datatype))
```

**Examples:**
```c
int arr[5] = {10, 20, 30, 40, 50};
int *p = arr;               // p points to arr[0]

printf("%d\n", *p);         // 10
printf("%d\n", *(p+1));     // 20 (arr[1])
printf("%d\n", *(p+2));     // 30 (arr[2])

p++;                        // p now points to arr[1]
printf("%d\n", *p);         // 20

p += 2;                     // p now points to arr[3]
printf("%d\n", *p);         // 40

printf("%ld\n", p - arr);   // Offset: 3 (elements, not bytes)
```

---

### Pointer to Function

```c
return_type (*ptr_name)(argument_types);
```

**Example:**
```c
// Define function
int add(int x, int y) {
    return x + y;
}

// Pointer to function
int (*fp)(int, int);            // Declare function pointer
fp = &add;                      // Or simply: fp = add;

// Call via pointer
int result = fp(5, 10);         // result = 15
printf("%d\n", (*fp)(5, 10));   // Same, explicit dereference

// Array of function pointers
int (*funcs[3])(int, int) = {add, subtract, multiply};
```

---

### Void Pointer

- Generic pointer; can point to any data type
- Cannot be dereferenced directly; must be cast
- Used for generic memory operations (malloc, memcpy, etc.)

```c
int x = 10;
float y = 3.14;

void *ptr = &x;             // Can point to any type
ptr = &y;                   // No type mismatch error

// Must cast before use
int *iptr = (int *) ptr;
float *fptr = (float *) ptr;
```

### Dangling Pointer

```c
int *p = (int*) malloc(sizeof(int));
free(p);
p = NULL;  // Good practice; avoid using p after free
// *p is now a dangling pointer if p is not NULL'd
```

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

```c
// Character array (null-terminated)
char str[20] = "Hello";     // "Hello\0" (6 chars + null)

// Pointer to string (points to string literal)
char *str2 = "World";       // String stored in read-only memory

// Manual termination
char str3[5] = {'H', 'i', '\0'};  // Must include \0

printf("%s\n", str);        // Hello
printf("%lu\n", strlen(str)); // 5 (excluding \0)
```

---

### Standard String Functions (string.h)

```c
#include <string.h>

char src[20] = "Hello";
char dest[20];

// strlen: get length
printf("%lu\n", strlen(src));   // 5

// strcpy: copy string (unsafe; no bounds check)
strcpy(dest, src);              // dest = "Hello"

// strncpy: copy n characters (safer)
strncpy(dest, src, 3);          // dest = "Hel\0"

// strcmp: compare strings (returns 0 if equal)
if (strcmp(src, dest) == 0) {
    printf("Strings are equal\n");
}

// strcat: concatenate (unsafe)
strcat(src, dest);              // src = "HelloHello"

// strncat: concatenate n characters (safer)
strncat(src, dest, 3);          // src += "Hel"

// strchr: find character
char *pos = strchr(src, 'l');   // pos points to first 'l'

// strstr: find substring
char *sub = strstr(src, "lo");  // pos points to "lo"
```

---

### Character Classification (ctype.h)

```c
#include <ctype.h>

isdigit('5');       // 1 (true)
isalpha('a');       // 1 (true)
isalnum('a1');      // 1 (true)
isspace(' ');       // 1 (true)
isupper('A');       // 1 (true)
islower('a');       // 1 (true)
toupper('a');       // 'A'
tolower('A');       // 'a'
```

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
#include <stdlib.h>

// Allocate memory for string
char *str = (char*) malloc(50 * sizeof(char));
if (str == NULL) {
    printf("Memory allocation failed\n");
    return;
}

strcpy(str, "Dynamic string");
printf("%s\n", str);

free(str);
str = NULL;         // Good practice

// Using calloc (zero-initialized)
char *str2 = (char*) calloc(50, sizeof(char));
// All bytes initialized to 0
free(str2);
str2 = NULL;
```

---

## SECTION 11: STRUCTURES & UNIONS

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

**Self-referential Structures**
```c
// Self-referential structure
struct Node
{
    int data;
    struct Node *next;  // Points to another Node
};

// For trees:
struct TreeNode
{
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
};
```

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

## SECTION 12: DATA STRUCTURES

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

## SECTION 13: TREES

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
- Parent of node i: (i-1)/2
- Left child of i: 2*i + 1
- Right child of i: 2*i + 2

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

## SECTION 14: TIME & SPACE COMPLEXITY

### Data Structure Complexity Table

| Data Structure | Access | Search | Insert | Delete | Space |
|---|---|---|---|---|---|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| Singly LL | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Doubly LL | O(n) | O(n) | O(1)* | O(1)* | O(n) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) | O(n) |
| BST | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(logn) avg, O(n) worst | O(n) |

**Note:** *O(1) for insertion/deletion at known position; O(n) if position must be found


