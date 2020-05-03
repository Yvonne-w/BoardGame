# New Code for Deliverable D2E

## < u7020050 > < Yiwei Wu >

For Deliverable D2E, I contributed the following new statements of original code:

- Test: tests/comp1110/ass2/D2Eu7020050.java
- New Code as below:

1. static int[] tileCode = new int[8];
2. 
3.     public static int[] encodeTile(String tilePlacement) {
4.         String tileString = tilePlacement.substring(0, 4);
5.         for (int i = 0; i < tileString.length(); i++) {
6.             int posInArray = 2 * i;
7.             int union = i + 1;
8.             if (tileString.charAt(i) == 'a') {
9.                 tileCode[posInArray] = union;
10.                 switch (posInArray) {
11.                     case 0:
12.                         tileCode[5] = union;
13.                         break;
14.                     case 2:
15.                         tileCode[7] = union;
16.                         break;
17.                     case 4:
18.                         tileCode[1] = union;
19.                         break;
20.                     case 6:
21.                         tileCode[3] = union;
22.                         break;
23.                 }
24.             } else if (tileString.charAt(i) == 'b') {
25.                 tileCode[posInArray] = union;
26.                 switch (posInArray) {
27.                     case 0:
28.                         tileCode[3] = union;
29.                         break;
30.                     case 2:
31.                         tileCode[5] = union;
32.                         break;
33.                     case 4:
34.                         tileCode[7] = union;
35.                         break;
36.                     case 6:
37.                         tileCode[1] = union;
38.                         break;
39.                 }
40.             } else if (tileString.charAt(i) == 'c') {
41.                 tileCode[posInArray] = union;
42.                 switch (posInArray) {
43.                     case 0:
44.                         tileCode[7] = union;
45.                         break;
46.                     case 2:
47.                         tileCode[1] = union;
48.                         break;
49.                     case 4:
50.                         tileCode[3] = union;
51.                         break;
52.                     case 6:
53.                         tileCode[5] = union;
54.                         break;
55.                 }
56.             } else if (tileString.charAt(i) == 'd') {
57.                 tileCode[posInArray] = union;
58.                 switch (posInArray) {
59.                     case 0:
60.                         tileCode[1] = union;
61.                         break;
62.                     case 2:
63.                         tileCode[3] = union;
64.                         break;
65.                     case 4:
66.                         tileCode[5] = union;
67.                         break;
68.                     case 6:
69.                         tileCode[7] = union;
70.                         break;
71.                 }
72.             }
73.         }
74.         return tileCode;
75. 
76.     }

(List at least 20, including at least one new unit test, and include line numbers.)
