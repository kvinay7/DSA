<h1 align="center">Programming in C & DSA</h1>

## SECTION 1: C FUNDAMENTALS

### Standard Header Files

| **Header File** | **Purpose / Common Functions**                                                                     |
| --------------- | -------------------------------------------------------------------------------------------------- |
| `stdio.h`       | Standard Input/Output (`printf()`, `scanf()`, `fopen()`, `fclose()`, etc.)                         |
| `stdlib.h`      | Standard library functions (`malloc()`, `free()`, `atoi()`, `rand()`, `exit()`, etc.)              |
| `string.h`      | String handling functions (`strlen()`, `strcpy()`, `strcmp()`, `strcat()`, etc.)                   |
| `ctype.h`       | Character classification and conversion (`isalpha()`, `isdigit()`, `toupper()`, `tolower()`, etc.) |
| `math.h`        | Mathematical functions (`sqrt()`, `pow()`, `sin()`, `cos()`, `log()`, etc.)                        |
| `limits.h`      | Defines minimum and maximum values for data types (`INT_MAX`, `INT_MIN`, `CHAR_MAX`, etc.)         |
| `stdbool.h`     | Boolean data type and constants (`bool`, `true`, `false`)                                          |


### Data Types & Sizes (Typical 32-bit Implementation)

| **Data Type**    | **Size**  | **Range**                        | **Format Specifier** |
| ---------------- | --------- | -------------------------------- | -------------------- |
| `char`           | 1 byte    | -128 to 127                      | `%c`                 |
| `signed char`    | 1 byte    | -128 to 127                      | `%c`                 |
| `unsigned char`  | 1 byte    | 0 to 255                         | `%c`                 |
| `short int`      | 2 bytes   | -32,768 to 32,767                | `%hi`                |
| `unsigned short` | 2 bytes   | 0 to 65,535                      | `%hu`                |
| `int`            | 4 bytes   | -2,147,483,648 to 2,147,483,647  | `%d` or `%i`         |
| `unsigned int`   | 4 bytes   | 0 to 4,294,967,295               | `%u`                 |
| `long int`       | 4 bytes*  | -2,147,483,648 to 2,147,483,647* | `%ld`                |
| `unsigned long`  | 4 bytes*  | 0 to 4,294,967,295*              | `%lu`                |
| `float`          | 4 bytes   | 3.4 × 10⁻³⁸ to 3.4 × 10³⁸        | `%f`                 |
| `double`         | 8 bytes   | 1.7 × 10⁻³⁰⁸ to 1.7 × 10³⁰⁸      | `%lf`                |
| `long double`    | 10 bytes* | 3.4 × 10⁻⁴⁹³² to 3.4 × 10⁴⁹³²    | `%Lf`                |

**Note:** C does not guarantee exact sizes; values depend on compiler/architecture.

### Type Qualifiers
```
const              Value cannot be modified after initialization
volatile           Value can be changed by external hardware/device
```

### Preprocessor Directives

```c
#include <stdio.h>     // System header (angle brackets)
#include "myheader.h"  // Local header (quotes)

#define PI 3.14159
#define MAX(a,b) ((a)>(b)?(a):(b))
#define SQUARE(x) ((x)*(x))

#undef MAX

#ifdef DEBUG
    printf("Debug mode\n");
#endif

#ifndef MAX_SIZE
    #define MAX_SIZE 100
#endif

#if          Conditional (compile if expression true)
#else        Alternative block
#elif        Else if
#pragma      Compiler-specific instructions
```

### Command Line Arguments

```c
int main(int argc, char *argv[]) {
    // argc: argument count (number of strings)
    // argv: argument vector (array of strings)
    
    for (int i = 0; i < argc; i++) {
        printf("%s\n", argv[i]);  // Print each argument
    }
    return 0;
}

// Example: ./program arg1 arg2
// argc = 3
// argv[0] = "./program"
// argv[1] = "arg1"
// argv[2] = "arg2"
```

### Type Casting
```c
(int) 3.14         // Explicit cast to int
(float) 5          // Cast int to float
(char *) ptr       // Cast pointer type
```

---

## SECTION 2: OPERATORS

### Arithmetic Operators
```
+   Addition       →  a + b
-   Subtraction    →  a - b
*   Multiplication →  a * b
/   Division       →  a / b  (integer division if both int)
%   Modulo         →  a % b  (result sign follows dividend)
```

### Increment/Decrement Operators
```
++x     Pre-increment   (increment first, then use)
x++     Post-increment  (use first, then increment)
--x     Pre-decrement   (decrement first, then use)
x--     Post-decrement  (use first, then decrement)

Example:
int a = 5, b;
b = ++a;   // a becomes 6, b = 6 (pre-increment)
b = a++;   // a becomes 7, b = 6 (post-increment)
```

### Bitwise Operators
```
&   Bitwise AND        →  a & b
|   Bitwise OR         →  a | b
^   Bitwise XOR        →  a ^ b
~   Bitwise NOT        →  ~a  (1's complement: ~n = -(n+1))
<<  Left shift         →  a << n  (multiply by 2^n)
>>  Right shift        →  a >> n  (divide by 2^n)
```

**Bitwise Truth Table**

| A | B | A&B | A\|B | A^B | ~A |
|---|---|-----|------|-----|-----|
| 1 | 1 |  1  |  1   |  0  |  0  |
| 1 | 0 |  0  |  1   |  1  |  0  |
| 0 | 1 |  0  |  1   |  1  |  1  |
| 0 | 0 |  0  |  0   |  0  |  1  |

### Assignment Operators
```
=   x = 5              +=  x += 3          -=  x -= 3
*=  x *= 3             /=  x /= 2          %=  x %= 3
&=  x &= y             |=  x |= y          ^=  x ^= y
<<= x <<= 2            >>= x >>= 2
```

### Relational Operators
```
>   Greater than           <   Less than
>=  Greater or equal       <=  Less or equal
==  Equal                  !=  Not equal
```

### Logical Operators
```
&&  AND (short-circuit)    ||  OR (short-circuit)    !   NOT
```

### Ternary Operator
```
condition ? value_if_true : value_if_false
```

### Special Operators
```
sizeof(x)        Size in bytes
&x               Address of x
*ptr             Dereference pointer
(type)           Type casting
.                Member selection (struct)
->               Pointer to member
```

### Operator Precedence (High to Low)

| Priority | Operator | Associativity |
|----------|----------|---------------|
| 1 | () [] . -> | Left to Right |
| 2 | ! ~ ++ -- + - (type) * & sizeof | Right to Left |
| 3 | * / % | Left to Right |
| 4 | + - | Left to Right |
| 5 | << >> | Left to Right |
| 6 | < <= > >= | Left to Right |
| 7 | == != | Left to Right |
| 8 | & | Left to Right |
| 9 | ^ | Left to Right |
| 10 | \| | Left to Right |
| 11 | && | Left to Right |
| 12 | \|\| | Left to Right |
| 13 | ?: | Right to Left |
| 14 | = += -= *= /= %= &= \|= ^= <<= >>= | Right to Left |
| 15 | , | Left to Right |

---

## SECTION 3: FUNCTIONS

### Function Prototype
```c
return_type function_name(parameter_types);

Example:
int add(int, int);      // Declares function (tells compiler signature)
int add(int a, int b) { // Defines function
    return a + b;
}
```

### Function Definition
```c
return_type function_name(parameter_list) {
    statements;
    return value;
}
```

**Call by Value**
```c
void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}
// Original variables NOT modified
```

**Call by Reference**
```c
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}
swap(&x, &y);
// Original variables ARE modified
```

### Recursion
- Function calling itself
- Must have base case to prevent infinite recursion
- Executed in LIFO order (stack-based)
- Each call uses stack memory

---

## SECTION 4: ARRAYS

### Array Declaration
```c
int arr[10];                    // 1D array, size 10
int arr[5][3];                  // 2D array, 5 rows × 3 columns
int *arr[10];                   // Array of 10 pointers
```

### Array Properties
- Contiguous memory locations
- Fixed size (static allocation)
- All elements same data type
- 0-indexed
- Cannot be resized after creation
- Can initialize with values: `int arr[5] = {1,2,3,4,5};`
- **Array name behaves like constant pointer in expressions**

### 2D Array Address Calculation
```
For array arr[m][n]:
Address of arr[i][j] = base_address + ((i × n) + j) × size_of_element

Row-major (C): address = base + (i×cols + j) × size
Column-major: address = base + (j×rows + i) × size
```

### Passing Arrays to Functions
```c
// 1D array - passes base address (pointer)
void modify(int arr[], int size)

// 2D array - column size MUST be specified
void modify(int arr[][3], int rows)

// Array of pointers
void modify(int *arr[])
```

---

## SECTION 5: POINTERS

### Pointer Basics
```c
int a = 5;
int *p = &a;      // p points to a
*p = 10;           // Dereference: change value at address
p++;               // Move to next address (size-dependent)
*(p+1)             // Value at next address
```

**Pointer Arithmetic**
```
Pointer arithmetic depends on data type size.
If int *p and p = 1000:
    p++  →  p = 1004 (moves by sizeof(int) = 4)
If char *q and q = 1000:
    q++  →  q = 1001 (moves by sizeof(char) = 1)
```

### Pointer Types

**NULL Pointer**
```c
int *p = NULL;     // Pointer points to nothing
if (p == NULL) {   // Safe check
    printf("Pointer is NULL\n");
}
```

**void Pointer (Generic Pointer)**
```c
void *ptr;         // Can point to any data type
int a = 5;
ptr = &a;          // Valid (implicit conversion)
printf("%d", *(int*)ptr);  // Cast to use
```

**Dangling Pointer**
```c
int *p;
{
    int a = 5;
    p = &a;    // Points to local variable
}
// p now points to deallocated memory (dangling)
*p;            // Undefined behavior
```

**Wild Pointer**
```c
int *p;        // Declared but not initialized
*p = 10;       // Undefined behavior (points to random memory)
```

### Pointer Operations
```c
&variable          Address of variable
*pointer           Dereference (value at address)
ptr++              Move to next memory location
ptr + n            Move n positions ahead
ptr - ptr2         Distance between two pointers
ptr[i]             Same as *(ptr + i)
```

### Pointer to Function
```c
return_type (*ptr)(param_types)

Example:
int (*ptr)(int, int)     // ptr points to function taking 2 ints, returning int
ptr = &add;              // Assign function address
result = (*ptr)(5, 3);   // Call via pointer
```

### Array of Pointers
```c
int *arr[5];           // Array of 5 pointers to int
arr[0] = &x;           // First pointer points to x
arr[1] = &y;           // Second pointer points to y
*arr[0]                // Value at first pointer's address
```

### Dynamic Memory
```c
malloc(size)          // Allocate size bytes, return void*
calloc(n, size)       // Allocate n×size bytes, initialize to 0
realloc(ptr, size)    // Resize previously allocated memory
free(ptr);            // Deallocate memory
ptr = NULL;           // IMPORTANT: Set to NULL after free
```

**Example**
```c
int *arr = (int*) malloc(10 * sizeof(int));
if (arr == NULL) {
    printf("Memory allocation failed\n");
    exit(1);
}
free(arr);
arr = NULL;
```

---

## SECTION 6: STRINGS (string.h)

### String Basics
```c
char str[20] = "Hello";        // Null-terminated by default
char str[] = {'H','e','l','l','o','\0'};  // Manual null termination
```

### String Functions (Standard)
```c
strlen(s)              // Length of string (without \0)
strcpy(dest, src)      // Copy src to dest
strncpy(dest,src,n)    // Copy first n characters
strcat(dest, src)      // Append src to dest
strncat(dest,src,n)    // Append first n characters
strcmp(s1, s2)         // Compare: 0 if equal, <0 if s1<s2, >0 if s1>s2
strncmp(s1,s2,n)       // Compare first n characters
strchr(s, c)           // Find first occurrence of char c
strstr(s1, s2)         // Find substring s2 in s1
```

### Memory Functions (string.h / stdlib.h)
```c
memcpy(dest, src, n)      // Copy n bytes from src to dest
memmove(dest, src, n)     // Copy n bytes (handles overlapping regions)
memset(ptr, value, n)     // Fill n bytes with value
memcmp(ptr1, ptr2, n)     // Compare n bytes
```

### Character Functions (ctype.h)
```c
isalpha(c)             // Is letter?
isdigit(c)             // Is digit?
isalnum(c)             // Is alphanumeric?
isspace(c)             // Is whitespace?
isupper(c)             // Is uppercase?
islower(c)             // Is lowercase?
toupper(c)             // Convert to uppercase
tolower(c)             // Convert to lowercase
```

### stdlib.h Functions
```c
atoi(str)              // String to integer
atof(str)              // String to float
atol(str)              // String to long
```

---

## SECTION 7: I/O FUNCTIONS

### Unformatted I/O
```c
getchar()              // Read single character
putchar(c)             // Print single character
fgets(str, n, stdin)   // Read string (up to n-1 characters)
puts(str)              // Print string with newline
```

### Formatted I/O
```c
printf(format, args)   // Print formatted output
scanf(format, &args)   // Read formatted input
```

**Format Specifiers**
```
%c       Character
%d       Decimal integer (signed)
%i       Integer
%u       Unsigned integer
%o       Octal
%x / %X  Hexadecimal (lowercase/uppercase)
%f       Float (6 decimal places default)
%e / %E  Scientific notation
%s       String
%p       Pointer address
%%       Literal %
```

**Escape Sequences**
```
\n       Newline
\t       Tab
\r       Carriage return
\b       Backspace
\a       Alert/bell
\\       Backslash
\'       Single quote
\"       Double quote
\0       Null character
```

---

## SECTION 8: FILE HANDLING

### File Operations
```c
FILE *fp;
fp = fopen("filename", "mode");    // Open file
fclose(fp);                        // Close file
```

**File Modes (Text)**
```
r        Read (file must exist)
w        Write (creates or truncates)
a        Append (creates or appends)
r+       Read and write
w+       Write and read
a+       Append and read
```

**File Modes (Binary)**
```
rb       Read binary
wb       Write binary
ab       Append binary
rb+      Read/write binary
wb+      Write/read binary
ab+      Append/read binary
```

### File Functions
```c
fgetc(fp)              // Read single character
fputc(c, fp)           // Write single character
fgets(str, n, fp)      // Read string (n-1 chars max)
fputs(str, fp)         // Write string
fscanf(fp, fmt, &var)  // Read formatted
fprintf(fp, fmt, var)  // Write formatted
fread(ptr, size, n, fp)    // Read n items of size bytes
fwrite(ptr, size, n, fp)   // Write n items of size bytes
```

### File Positioning
```c
fseek(fp, offset, position)    // Seek to position
ftell(fp)                      // Current position
rewind(fp)                     // Go to beginning

// position values:
// SEEK_SET (0)  - beginning
// SEEK_CUR (1)  - current
// SEEK_END (2)  - end
```

### File Status
```c
feof(fp)               // End of file?
ferror(fp)             // Error occurred?
clearerr(fp)           // Clear error flag
remove(filename)       // Delete file
rename(old, new)       // Rename file
```

---

## SECTION 9: STRUCTURES, UNIONS & ENUMS

### Structure Declaration
```c
struct Student {
    int roll;
    char name[30];
    float gpa;
};

struct Student s1;      // Create instance
s1.roll = 101;         // Access member
```

### typedef
```c
typedef struct {
    int roll;
    char name[30];
} Student;

Student s1;            // No 'struct' keyword needed
```

### Nested Structures
```c
struct Address {
    char city[20];
    int zip;
};

struct Person {
    char name[30];
    struct Address addr;    // Nested structure
};

person.addr.city = "Delhi";
```

### Self-Referential Structures
```c
struct Node {
    int data;
    struct Node *next;     // Pointer to same type
};
```

### Bit-fields
```c
struct Flags {
    unsigned int flag1 : 1;    // 1 bit
    unsigned int flag2 : 2;    // 2 bits
    unsigned int flag3 : 1;    // 1 bit
};
```

**Notes**
- Saves memory for boolean/small integer values
- Bit-fields are implementation-dependent
- Cannot take address of bit-field
- Not portable across compilers

### Enumerations
```c
enum color {RED, GREEN, BLUE};      // RED=0, GREEN=1, BLUE=2
enum color {RED=1, GREEN=2, BLUE=3}; // Assign values
enum color c = RED;

// Advantages: More readable than using integers, Type-safe and Compiler can check for invalid values.
```

### Unions
```c
union Data {
    int i;
    float f;
    char c;
};

// All members share same memory (size = size of largest member)
// Only one member can hold value at a time
```

**struct vs union**
- struct: each member has separate memory
- union: all members share same memory
- Size of struct ≥ sum of member sizes (due to padding and alignment)
- Size of union = size of largest member

**Padding and Alignment** (GATE Point)
- Compiler pads struct members for efficient memory access
- Size may be > sum of individual member sizes
- Alignment ensures faster access to members

---

## SECTION 10: STACKS

### Stack Operations (LIFO - Last In First Out)

**Basic Operations**
```
push(x)        Add element to top
pop()          Remove and return top element
top/peek()     Return top element without removing
isEmpty()      Check if stack is empty
size()         Return number of elements
```

**Stack Properties**
```
- If TOP == size-1: Stack is FULL (overflow if push attempted)
- If TOP == -1: Stack is EMPTY (underflow if pop attempted)
- Max elements with array size n: n
```

**Applications**
- Function call stack (recursion)
- Expression evaluation (infix → postfix)
- Balanced parentheses checking
- Undo/Redo functionality
- Backtracking problems
- DFS traversal

**Stack Permutations**
- Valid output permutations from stack = Catalan number = C(n) = (2n)! / ((n+1)! × n!)
- For n=3: C(3) = 5 valid permutations

---

## SECTION 11: QUEUES

### Queue Operations (FIFO - First In First Out)

**Basic Operations**
```
enqueue(x)     Add element to rear
dequeue()      Remove and return front element
front()        Return front element
rear()         Return rear element
isEmpty()      Check if empty
isFull()       Check if full
```

**Queue Properties**
```
- If REAR == size-1: Queue is FULL (overflow if enqueue)
- If FRONT == -1: Queue is EMPTY (underflow if dequeue)
```

### Types of Queues

**Circular Queue**
- Rear wraps around to use space freed by dequeue
- Avoids wasting array space
- Enqueue: rear = (rear + 1) % size
- Dequeue: front = (front + 1) % size
- Empty: front == -1 (after complete drain)
- Full: (rear + 1) % size == front

**Double Ended Queue (Deque)**
- Insert and delete at both ends
- Input-restricted: insert one end, delete both
- Output-restricted: insert both, delete one end

**Priority Queue**
- Elements removed by priority, not by insertion order
- Higher priority dequeued first
- If same priority: FIFO order

**Applications**
- CPU scheduling
- Disk scheduling
- Print job queue
- BFS traversal
- Resource allocation

---

## SECTION 12: LINKED LISTS

### Singly Linked List

**Node Structure**
```c
struct Node {
    int data;
    struct Node *next;
};
```

**Operations**
```
Create: Allocate node, initialize pointers
Insert: Add at beginning (O(1)), middle (O(n)), end (O(n))
Delete: Remove node from any position
Traverse: Visit all nodes
Search: Find element
Display: Print all elements
```

**Advantages**
- Dynamic size
- No waste of memory
- Efficient insertion/deletion

**Disadvantages**
- Extra memory for pointers
- No random access
- Traversal is sequential only

### Doubly Linked List

**Node Structure**
```c
struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};
```

**Advantages**
- Traverse forward and backward
- Deletion easier (can skip searching previous node)

**Disadvantages**
- Extra memory (2 pointers per node)
- Insertion/deletion slightly complex

### Circular Linked List

**Properties**
- Last node points to first node (not NULL)
- No beginning or end
- Useful for round-robin scheduling
- Traverse back from any node to same node

**Operations**
```
Similar to singly linked list
But: traverse until you reach first node again
     insertion/deletion: last node modified
```

---

## SECTION 13: TREES

### Tree Basics

**Definitions**
```
Node: Element in tree
Edge: Connection between nodes
Root: Top node (no parent)
Leaf: Node with no children
Internal Node: Non-leaf node
Path: Sequence of nodes and edges
Height: Maximum nodes from root to leaf
Depth: Distance from root to node
Level: Nodes at same depth
Degree of Node: Number of children
Degree of Tree: Maximum degree among all nodes
```

**Properties**
```
Nodes = Edges + 1  (N = E + 1)
If node at level k, its children at level k+1
If tree height h, max nodes = 2^h - 1
```

### General Tree
```
Tree where each node can have any number of children.
Degree of node = number of children.
Degree of tree = maximum degree among all nodes.
```

### Forest
```
A forest is a collection of disjoint trees.
If you remove root from tree, you get forest.
Forest with m nodes and n trees has (m - n) edges.
```

---

## SECTION 14: BINARY TREES

### Binary Tree Properties

**Max/Min Nodes**
```
Max nodes at level k = 2^k (0-indexed)
Max nodes in tree height h = 2^h - 1
Min height for n nodes = ceil(log₂(n+1))
Max height for n nodes = n (skewed tree)
```

### Types of Binary Trees

**Full Binary Tree (FBT)**
```
Every node has 0 or 2 children.
If n internal nodes: n+1 leaf nodes.
Total nodes = 2n + 1 (always odd).
Height h: n = (2^h - 1).
```

**Complete Binary Tree (CBT)**
```
All levels full except possibly last.
Last level filled left to right.
Height of CBT with n nodes = floor(log₂n).
Min nodes at height h = 2^(h-1).
Max nodes at height h = 2^h - 1.
```

**Perfect Binary Tree**
```
All internal nodes have 2 children.
All leaves at same level.
Total nodes = 2^h - 1.
```

**Balanced Binary Tree**
```
For every node: |height(left) - height(right)| ≤ 1.
Height = O(log n).
Examples: AVL, Red-Black trees.
```

**Skewed Binary Tree**
```
Every node has at most 1 child.
Can be left-skewed or right-skewed.
Height = n (worst case).
```

### Binary Tree Traversals

**Inorder (Left-Root-Right)**
```
Process left subtree → root → right subtree
BST inorder gives sorted order
Stack-based
```

**Preorder (Root-Left-Right)**
```
Process root → left subtree → right subtree
Used for copying tree
```

**Postorder (Left-Right-Root)**
```
Process left → right subtree → root
Used for deleting tree
```

**Level Order**
```
Visit by levels (BFS)
Uses queue
```

### Threaded Binary Tree

**Definition**
```
Binary tree where NULL pointers are replaced with thread pointers.
Thread pointers point to predecessor (inorder) or successor nodes.
```

**Advantages**
- Enables traversal without stack (non-recursive)
- Efficient space usage of NULL pointers
- O(1) access to predecessor/successor

**Types**
- Single-threaded: Only successor threads
- Double-threaded: Both predecessor and successor threads

---

## SECTION 15: BINARY SEARCH TREE (BST)

### BST Properties
```
Left subtree: all values < node value
Right subtree: all values > node value
```

### BST Operations
```
Search:   O(log n) average, O(n) worst (skewed)
Insert:   O(log n) average, O(n) worst
Delete:   O(log n) average, O(n) worst
Inorder:  Gives sorted order in O(n)
```

### Deletion Cases
```
Node is leaf: Simply remove
Node has 1 child: Replace with child
Node has 2 children: 
  - Find inorder successor (smallest in right subtree)
  - Replace node value with successor
  - Delete successor from right subtree
```

### Handling Duplicates
```
Convention in GATE:
- Insert duplicates in LEFT subtree (left < node)
- Or insert duplicates in RIGHT subtree (right ≥ node)
Check problem statement for convention.
```

---

## SECTION 16: BALANCED SEARCH TREES

### AVL Trees (Self-Balancing BST)

**Balance Factor**
```
BF(node) = height(left) - height(right)
Valid BF: -1, 0, +1
If |BF| > 1: tree is unbalanced, rebalance needed
```

**Rotations (after insertion/deletion)**
```
Left rotation:   Right child becomes new root
Right rotation:  Left child becomes new root
Left-Right:      Left rotation then right rotation
Right-Left:      Right rotation then left rotation
```

**Properties**
```
Height = O(log n)
Search/Insert/Delete = O(log n)
More balanced than Red-Black trees
More rotations during insertion/deletion
```

### Red-Black Trees

**Properties**
```
1. Every node is red or black
2. Root is black
3. Leaves (NULL) are black
4. If red, children are black
5. Every path root→leaf has same # black nodes
```

**Height**
```
Height = O(log n)
Max rotations during insert: 1
More efficient insertion than AVL
```

---

## SECTION 17: B-TREES

### B-Tree Properties
```
Order m: node can have m-1 keys and m children
All leaves at same level
Non-leaf non-root: min (m/2 - 1) keys, max (m-1) keys
Root: min 1 key
Leaf: 0 children, holds data
```

**Advantages**
```
Minimizes disk I/O (many keys per node)
Self-balancing
Height = O(log n)
Widely used in databases and file systems
```

**Operations**
```
Search:   O(log n)
Insert:   O(log n) with possible splits
Delete:   O(log n) with possible merges
```

---

## SECTION 18: HASHING

### Hash Function

**Purpose**
```
Map large key space to small table size
Distribute keys uniformly across hash table
```

**Properties of Good Hash Function**
```
1. Easy to compute
2. Distributes keys uniformly (minimize collisions)
3. Produces values evenly across range
4. Minimizes clustering
5. Deterministic (same key → same hash)
```

### Hash Function Methods

**Division Method**
```
h(k) = k mod m
where m = table size
Best when m is prime
Avoids clustering
```

**Multiplication Method**
```
h(k) = floor(m × (k×A mod 1))
where 0 < A < 1 (typically A = (√5 - 1)/2 ≈ 0.618)
m can be any value
```

**Mid-Square Method**
```
Square key, extract middle bits as hash
h(k) = middle r bits of k²
r = log₂(m)
```

**Folding Method**
```
Divide key into parts, add them
h(k) = (part1 + part2 + ... + partn) mod m
Good for long keys
```

**Digit Extraction**
```
Select specific digits from key
Useful for keys with patterns
```

### Perfect Hash Function
```
Hash function that maps distinct keys to distinct hash values.
No collisions.
Requires exact knowledge of keys beforehand.
```

### Universal Hashing
```
Family of hash functions where probability of collision ≤ 1/m.
Provides good average-case performance against adversarial input.
```

### Collision Resolution

**Open Addressing (Same Table)**

**Linear Probing**
```
If h(k) occupied, try h(k)+1, h(k)+2, ... (mod m)
Probe sequence: h(k), h(k)+1, h(k)+2, ..., h(k)+i (mod m)
Problem: Primary clustering (long sequences of filled slots)
```

**Quadratic Probing**
```
If h(k) occupied, try h(k)+1², h(k)+2², h(k)+3² (mod m)
Probe sequence: h(k), h(k)+1, h(k)+4, h(k)+9, ... (mod m)
Reduces clustering but requires m = prime power
```

**Double Hashing**
```
h(k, i) = (h1(k) + i×h2(k)) mod m
Two hash functions: h1(k) and h2(k)
h2(k) must be coprime with m
Best performance, minimal clustering
```

**Chaining (Separate Table)**
```
Each table position has linked list
Collision: insert into list
h(k) determines which list
```

**Advantages/Disadvantages**

| Method | Advantages | Disadvantages |
|--------|------------|---------------|
| Linear Probing | Simple, cache-friendly | Primary clustering |
| Quadratic Probing | Reduces clustering | Secondary clustering, prime size required |
| Double Hashing | Best clustering behavior | Complex, slower |
| Chaining | Simple, dynamic, easy delete | Extra memory, cache unfriendly |

### Load Factor

```
Load Factor α = n / m
where n = number of keys, m = table size
```

**Performance**
```
Average unsuccessful search:
- Linear Probing: 1/(1-α)
- Chaining: 1 + α
Average successful search:
- Linear Probing: (1 + 1/(1-α)) / 2
- Chaining: 1 + α/2
```

**Rehashing**
```
When α exceeds threshold (typically 0.75):
- Create new table (usually 2×m)
- Rehash all existing elements
- O(n) operation, but improves future operations
```

### Hash Table Operations

```
Insert:   h(k) → check collision → insert
Search:   h(k) → probe until found or empty slot
Delete:   h(k) → probe until found → mark as deleted
```

### Advantages/Disadvantages

**Advantages**
```
Average O(1) search, insert, delete
Simple to implement
No key comparisons needed
```

**Disadvantages**
```
Worst case O(n) (all collisions)
Order not preserved
Needs good hash function
Not suitable for range queries
```

---

## SECTION 19: STORAGE CLASSES & MEMORY LAYOUT

### Storage Classes

**auto**
```
Default for local variables
Automatic allocation/deallocation
Scope: block (local)
Lifetime: block duration
```

**extern**
```
Global scope across multiple files
Declared but defined elsewhere
Storage: static area
Lifetime: entire program
```

**static**
```
Local static: retains value between function calls
Global static: visible only in current file
Initialized to 0
Lifetime: entire program
```

**register**
```
Stored in CPU register (faster access)
Hint to compiler (not guaranteed)
Limited availability
Suitable for frequently used variables
```

### Memory Layout (Program)

**Typical Memory Organization**
```
High Address ┌──────────────────┐
             │  Command Line    │
             │  & Environment  │
             ├──────────────────┤
             │      Stack       │ ← Local variables
             │       ↓          │    Function parameters
             │       ...        │
             ├──────────────────┤
             │      Heap        │ ← malloc, calloc
             │       ↑          │
             │       ...        │
             ├──────────────────┤
             │  Uninitialized   │ ← Global/static variables (0)
             │  Data (BSS)      │
             ├──────────────────┤
             │ Initialized Data │ ← Global/static initialized
             ├──────────────────┤
             │      Code        │ ← Program instructions
Low Address  └──────────────────┘
```

**Stack**
- Local variables
- Function parameters
- Return addresses
- LIFO structure

**Heap**
- Dynamic memory allocation (malloc, calloc)
- Grows upward
- Managed manually (free)

**Static/Global**
- Global variables
- Static variables
- Initialized at program start

**Code**
- Program instructions
- Read-only

