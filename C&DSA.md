<h1 align="center">Programming in C & DSA</h1>

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

**Example**

```c
// auto: default for local variables (automatic deallocation)
{
    auto int x = 10;        // Scope: within block
    // x deallocated when block exits
}

// extern: external linkage (accessible across files)
extern int globalVar;       // Declaration
int globalVar = 100;        // Definition in one file

// static: file scope (limit visibility), persistent value
static int counter = 0;     // Visible only in this file
void increment() {
    static int callCount = 0;  // Persists across calls
    callCount++;
}

// register: compiler hint to use CPU register (rarely enforced)
register int i = 0;
```

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

<h1 align="center">DATA STRUCTURES</h1> 

## SECTION 1: Stacks

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

**Example**

```c
#define MAX 100

struct Stack {
    int arr[MAX];
    int top;
};

// Initialize stack
void init(struct Stack *s) {
    s->top = -1;
}

// Check if empty
int isEmpty(struct Stack *s) {
    return s->top == -1;
}

// Check if full
int isFull(struct Stack *s) {
    return s->top == MAX - 1;
}

// Push element
void push(struct Stack *s, int x) {
    if (isFull(s)) {
        printf("Stack overflow\n");
        return;
    }
    s->arr[++s->top] = x;
}

// Pop element
int pop(struct Stack *s) {
    if (isEmpty(s)) {
        printf("Stack underflow\n");
        return -1;
    }
    return s->arr[s->top--];
}

// Peek top element
int peek(struct Stack *s) {
    if (isEmpty(s)) return -1;
    return s->arr[s->top];
}

// Get size
int size(struct Stack *s) {
    return s->top + 1;
}

// Display all elements
void display(struct Stack *s) {
    if (isEmpty(s)) {
        printf("Stack is empty\n");
        return;
    }
    printf("Stack: ");
    for (int i = 0; i <= s->top; i++) {
        printf("%d ", s->arr[i]);
    }
    printf("\n");
}

int main() {
    struct Stack s;
    init(&s);
    
    push(&s, 10);
    push(&s, 20);
    push(&s, 30);
    display(&s);                   // 10 20 30
    
    printf("Popped: %d\n", pop(&s)); // 30
    printf("Top: %d\n", peek(&s));   // 20
    printf("Size: %d\n", size(&s));  // 2
    
    return 0;
}
```

**Time Complexity**
- Push: O(1)
- Pop: O(1)
- Search: O(n)

---

## SECTION 2: Queues

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

**Example**

```c
#define MAX 100

struct Queue {
    int arr[MAX];
    int front;
    int rear;
};

// Initialize queue
void init(struct Queue *q) {
    q->front = -1;
    q->rear = -1;
}

// Check if empty
int isEmpty(struct Queue *q) {
    return q->front == -1;
}

// Check if full
int isFull(struct Queue *q) {
    return q->rear == MAX - 1;
}

// Enqueue (add to rear)
void enqueue(struct Queue *q, int x) {
    if (isFull(q)) {
        printf("Queue overflow\n");
        return;
    }
    if (isEmpty(q)) q->front = 0;
    q->arr[++q->rear] = x;
}

// Dequeue (remove from front)
int dequeue(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue underflow\n");
        return -1;
    }
    int val = q->arr[q->front];
    if (q->front == q->rear) {
        q->front = q->rear = -1;
    } else {
        q->front++;
    }
    return val;
}

// Display all elements
void display(struct Queue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return;
    }
    printf("Queue: ");
    for (int i = q->front; i <= q->rear; i++) {
        printf("%d ", q->arr[i]);
    }
    printf("\n");
}
```

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

**Example**

```c
struct CircularQueue {
    int arr[MAX];
    int front;
    int rear;
};

void cq_enqueue(struct CircularQueue *q, int x) {
    if ((q->rear + 1) % MAX == q->front) {
        printf("Queue overflow\n");
        return;
    }
    if (q->front == -1) q->front = 0;
    q->rear = (q->rear + 1) % MAX;
    q->arr[q->rear] = x;
}

int cq_dequeue(struct CircularQueue *q) {
    if (q->front == -1) {
        printf("Queue underflow\n");
        return -1;
    }
    int val = q->arr[q->front];
    if (q->front == q->rear) {
        q->front = q->rear = -1;
    } else {
        q->front = (q->front + 1) % MAX;
    }
    return val;
}
```

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

## SECTION 3:  Linked Lists

**Singly Linked List**
- Forward traversal only
- Each node has data and link to next node

```c
struct Node {
    int data;
    struct Node *next;
};

// Create node
struct Node* createNode(int x) {
    struct Node *newNode = (struct Node*) malloc(sizeof(struct Node));
    newNode->data = x;
    newNode->next = NULL;
    return newNode;
}

// Insert at beginning
struct Node* insertAtBegin(struct Node *head, int x) {
    struct Node *newNode = createNode(x);
    newNode->next = head;
    return newNode;
}

// Insert at end
struct Node* insertAtEnd(struct Node *head, int x) {
    struct Node *newNode = createNode(x);
    if (head == NULL) return newNode;
    
    struct Node *current = head;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = newNode;
    return head;
}

// Delete first node
struct Node* deleteFirst(struct Node *head) {
    if (head == NULL) return NULL;
    struct Node *temp = head;
    head = head->next;
    free(temp);
    return head;
}

// Delete node with value x
struct Node* deleteNode(struct Node *head, int x) {
    if (head == NULL) return NULL;
    
    if (head->data == x) {
        struct Node *temp = head;
        head = head->next;
        free(temp);
        return head;
    }
    
    struct Node *current = head;
    while (current->next != NULL) {
        if (current->next->data == x) {
            struct Node *temp = current->next;
            current->next = temp->next;
            free(temp);
            return head;
        }
        current = current->next;
    }
    return head;
}

// Search
int search(struct Node *head, int x) {
    struct Node *current = head;
    while (current != NULL) {
        if (current->data == x) return 1;
        current = current->next;
    }
    return 0;
}

// Traverse and display
void display(struct Node *head) {
    struct Node *current = head;
    printf("List: ");
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

// Get length
int length(struct Node *head) {
    int len = 0;
    struct Node *current = head;
    while (current != NULL) {
        len++;
        current = current->next;
    }
    return len;
}

// Free entire list
void freeList(struct Node *head) {
    struct Node *current = head;
    while (current != NULL) {
        struct Node *temp = current;
        current = current->next;
        free(temp);
    }
}

int main() {
    struct Node *head = NULL;
    
    head = insertAtEnd(head, 10);
    head = insertAtEnd(head, 20);
    head = insertAtEnd(head, 30);
    display(head);                      // 10 -> 20 -> 30 -> NULL
    
    head = insertAtBegin(head, 5);
    display(head);                      // 5 -> 10 -> 20 -> 30 -> NULL
    
    printf("Search 20: %d\n", search(head, 20));  // 1
    printf("Length: %d\n", length(head));         // 4
    
    head = deleteNode(head, 20);
    display(head);                      // 5 -> 10 -> 30 -> NULL
    
    freeList(head);
    return 0;
}
```

**Doubly Linked List**
- Forward and backward traversal possible
- Each node has data, previous link, next link

```c
struct DNode {
    int data;
    struct DNode *prev;
    struct DNode *next;
};

struct DNode* createDNode(int x) {
    struct DNode *newNode = (struct DNode*) malloc(sizeof(struct DNode));
    newNode->data = x;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

// Insert at beginning
struct DNode* insertDAtBegin(struct DNode *head, int x) {
    struct DNode *newNode = createDNode(x);
    if (head == NULL) return newNode;
    
    newNode->next = head;
    head->prev = newNode;
    return newNode;
}

// Forward traversal
void displayForward(struct DNode *head) {
    printf("Forward: ");
    struct DNode *current = head;
    while (current != NULL) {
        printf("%d <-> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

// Backward traversal
void displayBackward(struct DNode *tail) {
    printf("Backward: ");
    struct DNode *current = tail;
    while (current != NULL) {
        printf("%d <-> ", current->data);
        current = current->prev;
    }
    printf("NULL\n");
}
```

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

## SECTION 4: TREES

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

**Example**

```c
struct TreeNode {
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
};

// Create node
struct TreeNode* createTreeNode(int x) {
    struct TreeNode *newNode = (struct TreeNode*) malloc(sizeof(struct TreeNode));
    newNode->data = x;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Insert in BST
struct TreeNode* insertBST(struct TreeNode *root, int x) {
    if (root == NULL) {
        return createTreeNode(x);
    }
    
    if (x < root->data) {
        root->left = insertBST(root->left, x);
    } else if (x > root->data) {
        root->right = insertBST(root->right, x);
    }
    // Ignore duplicate
    
    return root;
}

// Search in BST
int searchBST(struct TreeNode *root, int x) {
    if (root == NULL) return 0;
    
    if (x == root->data) return 1;
    else if (x < root->data) return searchBST(root->left, x);
    else return searchBST(root->right, x);
}

// Delete node from BST
struct TreeNode* deleteBST(struct TreeNode *root, int x) {
    if (root == NULL) return NULL;
    
    if (x < root->data) {
        root->left = deleteBST(root->left, x);
    } else if (x > root->data) {
        root->right = deleteBST(root->right, x);
    } else {
        // Node found
        
        // Case 1: No children (leaf)
        if (root->left == NULL && root->right == NULL) {
            free(root);
            return NULL;
        }
        
        // Case 2: One child
        if (root->left == NULL) {
            struct TreeNode *temp = root->right;
            free(root);
            return temp;
        }
        if (root->right == NULL) {
            struct TreeNode *temp = root->left;
            free(root);
            return temp;
        }
        
        // Case 3: Two children (find inorder successor)
        struct TreeNode *minLarger = root->right;
        while (minLarger->left != NULL) {
            minLarger = minLarger->left;
        }
        root->data = minLarger->data;
        root->right = deleteBST(root->right, minLarger->data);
    }
    
    return root;
}

// Inorder (Left-Node-Right) → Sorted for BST
void inorder(struct TreeNode *root) {
    if (root == NULL) return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}

// Preorder (Node-Left-Right) → Root first
void preorder(struct TreeNode *root) {
    if (root == NULL) return;
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

// Postorder (Left-Right-Node) → Root last
void postorder(struct TreeNode *root) {
    if (root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}

// Level-order (BFS)
void levelOrder(struct TreeNode *root) {
    if (root == NULL) return;
    
    struct Queue q;
    init(&q);
    enqueue(&q, (int)(intptr_t)root);
    
    while (!isEmpty(&q)) {
        struct TreeNode *node = (struct TreeNode*)(intptr_t)dequeue(&q);
        printf("%d ", node->data);
        
        if (node->left != NULL) enqueue(&q, (int)(intptr_t)node->left);
        if (node->right != NULL) enqueue(&q, (int)(intptr_t)node->right);
    }
}

// Get height
int height(struct TreeNode *root) {
    if (root == NULL) return -1;
    int leftH = height(root->left);
    int rightH = height(root->right);
    return 1 + (leftH > rightH ? leftH : rightH);
}

// Count nodes
int countNodes(struct TreeNode *root) {
    if (root == NULL) return 0;
    return 1 + countNodes(root->left) + countNodes(root->right);
}

// Sum of all nodes
int sumNodes(struct TreeNode *root) {
    if (root == NULL) return 0;
    return root->data + sumNodes(root->left) + sumNodes(root->right);
}

// Check if BST
int isBST(struct TreeNode *root, int min, int max) {
    if (root == NULL) return 1;
    
    if (root->data <= min || root->data >= max) return 0;
    
    return isBST(root->left, min, root->data) &&
           isBST(root->right, root->data, max);
}

// Check if balanced
int isBalanced(struct TreeNode *root) {
    if (root == NULL) return 1;
    
    int leftH = height(root->left);
    int rightH = height(root->right);
    
    if (leftH - rightH < -1 || leftH - rightH > 1) return 0;
    
    return isBalanced(root->left) && isBalanced(root->right);
}

// Free tree
void freeTree(struct TreeNode *root) {
    if (root == NULL) return;
    freeTree(root->left);
    freeTree(root->right);
    free(root);
}

int main() {
    struct TreeNode *root = NULL;
    
    root = insertBST(root, 50);
    root = insertBST(root, 30);
    root = insertBST(root, 70);
    root = insertBST(root, 20);
    root = insertBST(root, 40);
    root = insertBST(root, 60);
    root = insertBST(root, 80);
    
    printf("Inorder: ");
    inorder(root);              // 20 30 40 50 60 70 80
    printf("\n");
    
    printf("Preorder: ");
    preorder(root);
    printf("\n");
    
    printf("Height: %d\n", height(root));
    printf("Count: %d\n", countNodes(root));
    printf("Sum: %d\n", sumNodes(root));
    printf("Is BST: %d\n", isBST(root, INT_MIN, INT_MAX));
    
    freeTree(root);
    return 0;
}
```

---

## SECTION 5: TIME & SPACE COMPLEXITY

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

---

<h1 align="center">Algorithms</h1>

## 1. ASYMPTOTIC ANALYSIS

### Notation
- **O (Big-O):** Upper bound (worst case)
- **Ω (Omega):** Lower bound (best case)
- **Θ (Theta):** Tight bound (average case)

### Common Complexities (from fastest to slowest)
```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(n³) < O(2ⁿ) < O(n!)
```

### Master Theorem
For recurrence: **T(n) = aT(n/b) + f(n)**

| Case | Condition | Result |
|------|-----------|--------|
| 1 | f(n) = O(n^(log_b(a) - ε)) | T(n) = Θ(n^(log_b(a))) |
| 2 | f(n) = Θ(n^(log_b(a)) * log^k(n)) | T(n) = Θ(n^(log_b(a)) * log^(k+1)(n)) |
| 3 | f(n) = Ω(n^(log_b(a) + ε)) & a*f(n/b) ≤ c*f(n) | T(n) = Θ(f(n)) |

**Example:** Merge sort: T(n) = 2T(n/2) + O(n) → a=2, b=2, f(n)=O(n) → Case 2 → **Θ(n log n)**

---

## 2. SEARCHING

### Linear Search
**Pseudocode:**
```
LinearSearch(arr, n, key):
  for i = 0 to n-1:
    if arr[i] == key:
      return i
  return -1
```
**Complexity:** Best O(1), Avg O(n), Worst O(n) | Space O(1)

**C Snippet:**
```c
int linearSearch(int arr[], int n, int key) {
  for (int i = 0; i < n; i++)
    if (arr[i] == key) return i;
  return -1;
}
```

---

### Binary Search
**Prerequisite:** Array must be **sorted**.

**Pseudocode:**
```
BinarySearch(arr, low, high, key):
  while low <= high:
    mid = (low + high) / 2
    if arr[mid] == key:
      return mid
    else if arr[mid] < key:
      low = mid + 1
    else:
      high = mid - 1
  return -1
```
**Complexity:** Best O(1), Avg O(log n), Worst O(log n) | Space O(1) iterative, O(log n) recursive

**C Snippet (Iterative):**
```c
int binarySearch(int arr[], int n, int key) {
  int low = 0, high = n - 1;
  while (low <= high) {
    int mid = (low + high) / 2;
    if (arr[mid] == key) return mid;
    else if (arr[mid] < key) low = mid + 1;
    else high = mid - 1;
  }
  return -1;
}
```

**GATE Example:** Search for 35 in sorted array [10, 20, 30, 35, 40, 50].
- mid=30 (< 35), search right → mid=40 (> 35), search left → mid=35 ✓ Found in 3 comparisons.

---

## 3. SORTING

### Overview Table
| Algorithm | Best | Avg | Worst | Space | Stable | In-place |
|-----------|------|-----|-------|-------|--------|----------|
| Bubble | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Selection | O(n²) | O(n²) | O(n²) | O(1) | No | Yes |
| Insertion | O(n) | O(n²) | O(n²) | O(1) | Yes | Yes |
| Merge | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes | No |
| Quick | O(n log n) | O(n log n) | O(n²) | O(log n) | No | Yes |
| Heap | O(n log n) | O(n log n) | O(n log n) | O(1) | No | Yes |

---

### Bubble Sort
**Idea:** Repeatedly swap adjacent elements if they're in wrong order.

**Pseudocode:**
```
BubbleSort(arr, n):
  for i = 0 to n-1:
    for j = 0 to n-i-2:
      if arr[j] > arr[j+1]:
        swap(arr[j], arr[j+1])
```

**Complexity:** Best O(n) (already sorted, optimized), Avg O(n²), Worst O(n²) | Space O(1)

**C Snippet:**
```c
void bubbleSort(int arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    int swapped = 0;
    for (int j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
        swapped = 1;
      }
    }
    if (!swapped) break; // Already sorted
  }
}
```

---

### Selection Sort
**Idea:** Find minimum in unsorted part, place at beginning.

**Pseudocode:**
```
SelectionSort(arr, n):
  for i = 0 to n-2:
    min_idx = i
    for j = i+1 to n-1:
      if arr[j] < arr[min_idx]:
        min_idx = j
    swap(arr[i], arr[min_idx])
```

**Complexity:** Best O(n²), Avg O(n²), Worst O(n²) | Space O(1)

---

### Insertion Sort
**Idea:** Insert each element into its sorted position in the sorted part.

**Pseudocode:**
```
InsertionSort(arr, n):
  for i = 1 to n-1:
    key = arr[i]
    j = i - 1
    while j >= 0 and arr[j] > key:
      arr[j+1] = arr[j]
      j = j - 1
    arr[j+1] = key
```

**Complexity:** Best O(n) (sorted), Avg O(n²), Worst O(n²) | Space O(1)

**GATE Example:** Sort [5, 2, 8, 1, 9] using insertion sort.
- i=1: key=2, shift 5 → [2, 5, 8, 1, 9]
- i=2: key=8, no shift → [2, 5, 8, 1, 9]
- i=3: key=1, shift 8, 5, 2 → [1, 2, 5, 8, 9]
- i=4: key=9, no shift → [1, 2, 5, 8, 9] ✓

---

### Merge Sort (Divide & Conquer)
**Idea:** Divide array in half, recursively sort, merge.

**Pseudocode:**
```
MergeSort(arr, left, right):
  if left < right:
    mid = (left + right) / 2
    MergeSort(arr, left, mid)
    MergeSort(arr, mid+1, right)
    Merge(arr, left, mid, right)

Merge(arr, left, mid, right):
  Create temp arrays L[left...mid], R[mid+1...right]
  Copy arr[left...mid] to L, arr[mid+1...right] to R
  i = 0, j = 0, k = left
  while i < len(L) and j < len(R):
    if L[i] <= R[j]:
      arr[k++] = L[i++]
    else:
      arr[k++] = R[j++]
  Copy remaining L to arr
  Copy remaining R to arr
```

**Complexity:** Best O(n log n), Avg O(n log n), Worst O(n log n) | Space O(n)

**Analysis:** T(n) = 2T(n/2) + O(n) → Master Theorem Case 2 → **O(n log n)**

---

### Quick Sort (Divide & Conquer)
**Idea:** Partition around pivot, recursively sort left & right.

**Pseudocode:**
```
QuickSort(arr, low, high):
  if low < high:
    pi = Partition(arr, low, high)
    QuickSort(arr, low, pi-1)
    QuickSort(arr, pi+1, high)

Partition(arr, low, high):
  pivot = arr[high]
  i = low - 1
  for j = low to high-1:
    if arr[j] < pivot:
      i++
      swap(arr[i], arr[j])
  swap(arr[i+1], arr[high])
  return i + 1
```

**Complexity:** Best O(n log n), Avg O(n log n), Worst O(n²) (unbalanced pivot) | Space O(log n) recursive

**GATE Note:** Worst case occurs when pivot is always smallest/largest (e.g., already sorted array with first/last element as pivot).

**GATE Example:** Partition [3, 7, 8, 5, 2, 1, 9, 5, 4] with pivot=4.
- Compare: 3<4 (i=0), 7>4, 8>4, 5>4, 2<4 (swap 7↔2, i=1), 1<4 (swap 8↔1, i=2), 9>4, 5>4, 4==4 (swap 5↔4, i=3)
- Result: [3, 2, 1, 4, 7, 8, 9, 5, 5], pivot at index 3.

---

## 4. BINARY HEAPS

### Heap Property
- **Max-Heap:** Parent ≥ Children
- **Min-Heap:** Parent ≤ Children

### Array Representation
For node at index `i`:
- Left child: `2*i + 1`
- Right child: `2*i + 2`
- Parent: `(i - 1) / 2`

### Heapify (Down)
**Pseudocode (Max-Heap):**
```
Heapify(arr, n, i):
  largest = i
  left = 2*i + 1
  right = 2*i + 2
  
  if left < n and arr[left] > arr[largest]:
    largest = left
  if right < n and arr[right] > arr[largest]:
    largest = right
  
  if largest != i:
    swap(arr[i], arr[largest])
    Heapify(arr, n, largest)
```

**Complexity:** O(log n)

---

### Build Heap
**Pseudocode:**
```
BuildHeap(arr, n):
  for i = n/2 - 1 down to 0:
    Heapify(arr, n, i)
```

**Complexity:** O(n) (despite appearing O(n log n), sum of heapify costs is O(n))

---

### Insert
**Pseudocode:**
```
Insert(arr, n, value):
  arr[n] = value
  i = n
  while i > 0 and arr[(i-1)/2] < arr[i]:  // Max-heap
    swap(arr[i], arr[(i-1)/2])
    i = (i - 1) / 2
```

**Complexity:** O(log n)

---

### Delete (Root)
**Pseudocode:**
```
DeleteRoot(arr, n):
  arr[0] = arr[n-1]
  n = n - 1
  Heapify(arr, n, 0)
```

**Complexity:** O(log n)

---

### Heap Sort
**Pseudocode:**
```
HeapSort(arr, n):
  BuildHeap(arr, n)
  for i = n-1 down to 1:
    swap(arr[0], arr[i])
    Heapify(arr, i, 0)
```

**Complexity:** O(n log n) guaranteed (no worst case O(n²) like Quick Sort)

**GATE Example:** Heap sort [4, 10, 3, 5, 1].
- Build max-heap: [10, 5, 3, 4, 1]
- Swap 10↔1, heapify: [5, 4, 3, 1, 10]
- Swap 5↔1, heapify: [4, 1, 3, 5, 10]
- Continue... → [1, 3, 4, 5, 10] ✓

---

### Priority Queue
**Definition:** ADT where elements have priorities; higher priority dequeued first.

**Implementation:** Use max-heap (or min-heap for min-priority).
- Insert: O(log n)
- Delete-Max: O(log n)
- Extract-Max: O(1) peek, O(log n) remove

---

## 5. HASHING

### Hash Function
**Goal:** Map key to index in hash table. Ideally O(1) average access.

**Properties:**
- Deterministic (same key → same hash)
- Uniform distribution (minimize collisions)
- Efficient to compute

**Example (Simple):** `h(k) = k mod m` (m = table size)

---

### Collision Resolution

#### 1. Chaining (Separate Chaining)
**Idea:** Each hash table slot contains a linked list of collided elements.

**Pseudocode:**
```
Insert(key, value):
  i = hash(key)
  LinkedList_Insert(table[i], key, value)

Search(key):
  i = hash(key)
  return LinkedList_Search(table[i], key)

Delete(key):
  i = hash(key)
  LinkedList_Delete(table[i], key)
```

**Complexity:** Insert O(1) avg, Search O(1 + α) avg (α = load factor = n/m), Delete O(1 + α) avg
- **Worst Case:** O(n) if all keys hash to same slot

---

#### 2. Open Addressing
**Idea:** If slot occupied, probe for another slot using probe sequence.

##### Linear Probing
**Probe Sequence:** h(k, i) = (h(k) + i) mod m

```
Insert(key, value):
  i = 0
  while table[hash(key, i)] is occupied:
    i++
  table[hash(key, i)] = (key, value)

Search(key):
  i = 0
  while table[hash(key, i)] is not empty:
    if table[hash(key, i)].key == key:
      return table[hash(key, i)].value
    i++
  return NOT_FOUND
```

**Issue:** Primary clustering (consecutive occupied slots).

---

##### Quadratic Probing
**Probe Sequence:** h(k, i) = (h(k) + i²) mod m

**Reduces clustering** compared to linear probing.

---

##### Double Hashing
**Probe Sequence:** h(k, i) = (h₁(k) + i*h₂(k)) mod m

**Best performance** (minimal clustering). Requires h₂(k) to be coprime with m.

---

### Load Factor (α)
**Definition:** α = n / m (n = elements, m = table size)

**Effect on Complexity:**
- **Chaining:** Insert, Delete O(1), Search O(1 + α)
- **Open Addressing:** All operations O(1/(1-α)) avg (degrades as α → 1)

**Rehashing:** When α exceeds threshold (e.g., 0.75), double m and rebuild table. Cost: O(n).

---

### Comparison
| Method | Insert Avg | Search Avg | Space | Clustering |
|--------|-----------|-----------|-------|-----------|
| Chaining | O(1) | O(1+α) | O(n+m) | N/A |
| Linear Probing | O(1/(1-α)) | O(1/(1-α)) | O(m) | Primary |
| Quadratic Probing | O(1/(1-α)) | O(1/(1-α)) | O(m) | Secondary |
| Double Hashing | O(1/(1-α)) | O(1/(1-α)) | O(m) | Minimal |

**GATE Example:** Insert keys [20, 40, 50, 70, 80] into hash table size m=7 using h(k)=k mod 7 and linear probing.
- 20 mod 7 = 6 → table[6]=20
- 40 mod 7 = 5 → table[5]=40
- 50 mod 7 = 1 → table[1]=50
- 70 mod 7 = 0 → table[0]=70
- 80 mod 7 = 3 → table[3]=80
- Result: [70, 50, _, 80, _, 40, 20] ✓

---

## 6. ALGORITHM DESIGN TECHNIQUES

### 6.1 Divide & Conquer

**Pattern:**
1. **Divide:** Split problem into subproblems
2. **Conquer:** Solve subproblems recursively
3. **Combine:** Merge solutions

**Examples:** Merge Sort, Quick Sort, Binary Search, Strassen's Matrix Multiplication

**Analysis:** Use Master Theorem for recurrence relations.

---

### 6.2 Greedy

**Pattern:** Make locally optimal choice at each step; hope for global optimum.

#### Activity Selection Problem
**Problem:** Select maximum non-overlapping activities given start & end times.

**Greedy Strategy:** Always pick activity finishing earliest.

**Pseudocode:**
```
ActivitySelection(activities, n):
  Sort by finish time
  selected = [activities[0]]
  last_finish = activities[0].finish
  
  for i = 1 to n-1:
    if activities[i].start >= last_finish:
      selected.append(activities[i])
      last_finish = activities[i].finish
  
  return selected
```

**Complexity:** O(n log n) (sorting)

**Correctness:** Greedy choice (earliest finish) leaves maximum room for remaining activities.

**GATE Example:** Activities: (1,3), (2,5), (4,6), (6,8), (5,7), (8,9).
- Sort by finish: (1,3), (2,5), (4,6), (5,7), (6,8), (8,9)
- Select (1,3), skip (2,5), select (4,6), skip (5,7), select (6,8)? No (6≤8), select (8,9) ✓
- Max activities: 3

---

#### Fractional Knapsack
**Problem:** Maximize value with weight limit W; can take fractions of items.

**Greedy Strategy:** Pick items by value/weight ratio, highest first.

**Pseudocode:**
```
FractionalKnapsack(items, W):
  Sort by value/weight ratio (descending)
  total_value = 0
  current_weight = 0
  
  for each item:
    if current_weight + item.weight <= W:
      take entire item
      total_value += item.value
      current_weight += item.weight
    else:
      take fraction: (W - current_weight) / item.weight
      total_value += fraction * item.value
      current_weight = W
      break
  
  return total_value
```

**Complexity:** O(n log n)

**GATE Note:** Works for fractional knapsack; 0/1 knapsack requires DP.

---

#### Huffman Coding (Concept)
**Idea:** Build optimal binary tree for data compression using greedy merge.

**Algorithm:**
1. Create leaf node for each character (frequency = probability)
2. Repeatedly merge two nodes with smallest frequency
3. Assign 0 (left), 1 (right) to edges

**Complexity:** O(n log n)

---

### 6.3 Dynamic Programming

**Pattern:** Break problem into overlapping subproblems, memoize/tabulate results.

**Key Properties:**
- Optimal substructure
- Overlapping subproblems

#### 0/1 Knapsack Problem
**Problem:** Maximize value with weight limit W; can take 0 or 1 of each item.

**Recurrence:**
```
dp[i][w] = max value using first i items with weight limit w

dp[i][w] = max(
  dp[i-1][w],                           // don't take item i
  dp[i-1][w-weight[i]] + value[i]       // take item i (if weight[i] <= w)
)

Base: dp[0][w] = 0 (no items), dp[i][0] = 0 (no capacity)
```

**Pseudocode:**
```
Knapsack01(values, weights, W, n):
  dp = array[0..n][0..W] initialized to 0
  
  for i = 1 to n:
    for w = 1 to W:
      if weights[i-1] <= w:
        dp[i][w] = max(dp[i-1][w], 
                       dp[i-1][w-weights[i-1]] + values[i-1])
      else:
        dp[i][w] = dp[i-1][w]
  
  return dp[n][W]
```

**Complexity:** O(n*W) time, O(n*W) space (can optimize space to O(W) using rolling array)

**GATE Example:** Items: (val, weight) = (60,10), (100,20), (120,30). W=50.
```
    0   10  20  30  40  50
0   0   0   0   0   0   0
1   0   60  60  60  60  60
2   0   60  100 160 160 160
3   0   60  100 160 180 220
```
Max value = 220 (items 2,3 → weight 50, value 220) ✓

---

#### Longest Common Subsequence (LCS)
**Problem:** Find longest sequence of characters appearing in both strings in same order.

**Recurrence:**
```
lcs[i][j] = length of LCS of first i chars of s1, first j chars of s2

lcs[i][j] = 
  1 + lcs[i-1][j-1]           if s1[i-1] == s2[j-1]
  max(lcs[i-1][j], lcs[i][j-1]) otherwise

Base: lcs[0][j] = 0, lcs[i][0] = 0
```

**Complexity:** O(m*n) time & space

**GATE Example:** s1 = "AGGTAB", s2 = "GXTXAYB". LCS = "GTAB" (length 4).

---

#### Coin Change
**Problem:** Minimum coins needed to make amount.

**Recurrence:**
```
dp[i] = minimum coins to make amount i

dp[i] = 1 + min(dp[i - coin]) for all coins ≤ i

Base: dp[0] = 0
```

**Complexity:** O(n*m) (n = amount, m = coins)

**GATE Example:** Coins = [1,2,5], amount = 5. Answer = 1 coin (5).

---

#### Matrix Chain Multiplication
**Problem:** Find optimal parenthesization to minimize scalar multiplications.

**Recurrence:**
```
mcm[i][j] = minimum multiplications to compute matrices i to j

mcm[i][j] = min(mcm[i][k] + mcm[k+1][j] + cost of multiplying results)
            for k = i to j-1

Base: mcm[i][i] = 0
```

**Complexity:** O(n³)

---

## 7. GRAPHS

### Representation

#### Adjacency Matrix
**Definition:** 2D array where entry (i,j) = weight (or 1 if edge exists).

**Pros:** O(1) edge lookup
**Cons:** O(n²) space, slow for sparse graphs

---

#### Adjacency List
**Definition:** Array of linked lists; index i contains neighbors of vertex i.

**Pros:** O(V+E) space, efficient for sparse graphs
**Cons:** O(degree(v)) edge lookup

---

### Graph Traversals

#### Depth-First Search (DFS)
**Idea:** Explore deeply before backtracking.

**Pseudocode (Recursive):**
```
DFS(graph, v, visited):
  visited[v] = true
  for each neighbor u of v:
    if not visited[u]:
      DFS(graph, u, visited)

DFSFull(graph, V):
  visited = array[0..V-1] = false
  for v = 0 to V-1:
    if not visited[v]:
      DFS(graph, v, visited)
```

**Complexity:** O(V + E)

**C Snippet:**
```c
void DFS(int adj[][MAX], int V, int v, int visited[]) {
  visited[v] = 1;
  printf("%d ", v);
  for (int u = 0; u < V; u++) {
    if (adj[v][u] && !visited[u]) {
      DFS(adj, V, u, visited);
    }
  }
}
```

---

#### Breadth-First Search (BFS)
**Idea:** Explore level by level using queue.

**Pseudocode:**
```
BFS(graph, s, V):
  visited = array[0..V-1] = false
  queue = Queue()
  
  visited[s] = true
  queue.enqueue(s)
  
  while queue is not empty:
    v = queue.dequeue()
    for each neighbor u of v:
      if not visited[u]:
        visited[u] = true
        queue.enqueue(u)
```

**Complexity:** O(V + E)

**GATE Example:** BFS from vertex 0 in graph {0-1, 0-2, 1-3, 2-3}.
- Visit 0 → Queue: [1, 2]
- Visit 1 → Queue: [2, 3]
- Visit 2 → Queue: [3, 3] (3 may be added twice, but skipped if already visited)
- Visit 3
- Order: 0 → 1, 2 → 3 ✓

---

### Shortest Paths

#### Dijkstra's Algorithm (Greedy)
**Constraint:** Non-negative edge weights.

**Idea:** Maintain shortest distance; always expand closest unvisited vertex.

**Pseudocode:**
```
Dijkstra(graph, src, V):
  dist = array[0..V-1] = infinity
  dist[src] = 0
  visited = array[0..V-1] = false
  
  for _ = 0 to V-1:
    u = unvisited vertex with min dist[u]
    visited[u] = true
    
    for each neighbor v of u:
      if not visited[v] and dist[u] + weight(u,v) < dist[v]:
        dist[v] = dist[u] + weight(u,v)
  
  return dist
```

**Complexity:** O(V²) naive, O((V+E) log V) with min-heap

**GATE Example:** Shortest path from 0 in graph with edges (weights):
```
0-1(4), 0-2(2), 1-3(5), 2-1(1), 2-3(8), 3-1(3)
```
- dist = [0, ∞, ∞, ∞]
- Visit 0 → dist = [0, 4, 2, ∞]
- Visit 2 → dist = [0, 3, 2, 10] (0-2-1=3 < 4)
- Visit 1 → dist = [0, 3, 2, 8] (0-2-1-3=8 < 10)
- Visit 3
- Final: [0, 3, 2, 8] ✓

---

#### Bellman-Ford Algorithm (DP/Greedy)
**Constraint:** Can handle **negative edge weights** (but no negative cycles).

**Pseudocode:**
```
BellmanFord(graph, src, V, E):
  dist = array[0..V-1] = infinity
  dist[src] = 0
  
  for i = 0 to V-2:
    for each edge (u,v,w):
      if dist[u] + w < dist[v]:
        dist[v] = dist[u] + w
  
  // Check for negative cycle
  for each edge (u,v,w):
    if dist[u] + w < dist[v]:
      return "Negative cycle detected"
  
  return dist
```

**Complexity:** O(V*E)

**GATE Note:** Slower than Dijkstra but more general (handles negative weights).

---

#### Floyd-Warshall Algorithm (DP)
**Problem:** All-pairs shortest paths.

**Pseudocode:**
```
FloydWarshall(graph, V):
  dist = copy of adjacency matrix (∞ for non-edges)
  
  for k = 0 to V-1:                    // intermediate vertex
    for i = 0 to V-1:
      for j = 0 to V-1:
        if dist[i][k] + dist[k][j] < dist[i][j]:
          dist[i][j] = dist[i][k] + dist[k][j]
  
  return dist
```

**Complexity:** O(V³)

**GATE Example:** Compute all-pair shortest paths.
```
Input: 
  0→1(4), 1→3(2), 3→2(1), 2→1(2)
Output after Floyd-Warshall:
  dist[0][2] = 7 (0→1→3→2)
  dist[0][3] = 6 (0→1→3)
  dist[1][2] = 3 (1→3→2)
```

---

### Minimum Spanning Tree (MST)

#### Kruskal's Algorithm (Greedy + Union-Find)
**Idea:** Sort edges by weight; add edge if it doesn't create cycle (using Union-Find).

**Pseudocode:**
```
Kruskal(graph, V, E):
  mst = empty set
  UnionFind uf = new UnionFind(V)
  
  Sort edges by weight (ascending)
  
  for each edge (u,v,w) in sorted order:
    if uf.Find(u) != uf.Find(v):       // different components
      mst.add(edge)
      uf.Union(u, v)
      if |mst| == V-1:
        break
  
  return mst
```

**Complexity:** O(E log E) (sorting)

**GATE Example:** MST of edges (weights): (0,1,4), (0,2,2), (1,2,1), (1,3,5), (2,3,8), (3,4,3).
- Sort: (1,2,1), (0,2,2), (3,4,3), (0,1,4), (1,3,5), (2,3,8)
- Add (1,2,1) → MST = {(1,2,1)}
- Add (0,2,2) → MST = {(1,2,1), (0,2,2)}
- Add (3,4,3) → MST = {(1,2,1), (0,2,2), (3,4,3)}
- Add (0,1,4)? No, 0 & 1 already connected
- Add (1,3,5) → MST = {(1,2,1), (0,2,2), (3,4,3), (1,3,5)}
- Total weight = 11, |MST| = 4 = V-1 ✓

---

#### Prim's Algorithm (Greedy + Priority Queue)
**Idea:** Build MST by growing from a starting vertex; always add minimum edge crossing partition.

**Pseudocode:**
```
Prim(graph, src, V):
  visited = array[0..V-1] = false
  mst_weight = 0
  pq = min-heap (edge_weight, u, v)
  
  visited[src] = true
  Add all edges from src to pq
  
  while pq is not empty:
    (w, u, v) = pq.extract_min()
    if visited[v]:
      continue
    
    visited[v] = true
    mst_weight += w
    Add all edges from v to unvisited vertices to pq
  
  return mst_weight
```

**Complexity:** O((V+E) log V) with min-heap

**GATE Example:** Same as Kruskal above, MST weight = 11.

---

### Cycle Detection & Topological Sort

#### Cycle Detection (Undirected DFS)
**Idea:** If DFS visits an edge to an already-visited parent, cycle exists.

**Pseudocode:**
```
CycleDetect(graph, V):
  visited = array[0..V-1] = false
  
  for v = 0 to V-1:
    if not visited[v]:
      if DFS_Cycle(graph, v, -1, visited):
        return true
  
  return false

DFS_Cycle(graph, v, parent, visited):
  visited[v] = true
  for each neighbor u of v:
    if not visited[u]:
      if DFS_Cycle(graph, u, v, visited):
        return true
    else if u != parent:
      return true  // back edge → cycle
  
  return false
```

**Complexity:** O(V + E)

---

#### Topological Sort (DAG)
**Problem:** Order vertices such that for every edge u→v, u appears before v.

**Pseudocode (DFS-based):**
```
TopologicalSort(graph, V):
  visited = array[0..V-1] = false
  stack = Stack()
  
  for v = 0 to V-1:
    if not visited[v]:
      DFS_Topo(graph, v, visited, stack)
  
  result = []
  while stack is not empty:
    result.append(stack.pop())
  
  return result

DFS_Topo(graph, v, visited, stack):
  visited[v] = true
  for each neighbor u of v:
    if not visited[u]:
      DFS_Topo(graph, u, visited, stack)
  stack.push(v)
```

**Complexity:** O(V + E)

**GATE Example:** DAG with edges 5→2, 5→0, 4→0, 4→1, 2→3, 3→1.
- Topological order (one of many): 5 → 4 → 2 → 3 → 1 → 0 ✓

---

## 8. COMPLEXITY QUICK REFERENCE

| Problem | Algorithm | Time | Space |
|---------|-----------|------|-------|
| Search | Linear | O(n) | O(1) |
| | Binary | O(log n) | O(1) |
| Sort | Bubble, Insertion, Selection | O(n²) | O(1) |
| | Merge, Heap | O(n log n) | O(n), O(1) |
| | Quick | O(n log n) avg, O(n²) worst | O(log n) |
| Hash | Chaining | O(1+α) avg | O(n+m) |
| | Open Address | O(1/(1-α)) avg | O(m) |
| Heap | Insert, Delete | O(log n) | O(1) |
| | Build | O(n) | O(1) |
| Graph | DFS, BFS | O(V+E) | O(V) |
| | Dijkstra | O(V²) or O((V+E)logV) | O(V) |
| | Bellman-Ford | O(V*E) | O(V) |
| | Floyd-Warshall | O(V³) | O(V²) |
| | Kruskal | O(E log E) | O(V) |
| | Prim | O((V+E)logV) | O(V) |
| DP | 0/1 Knapsack | O(n*W) | O(n*W) |
| | LCS | O(m*n) | O(m*n) |

---

