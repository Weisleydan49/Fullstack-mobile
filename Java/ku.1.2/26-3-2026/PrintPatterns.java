public class PrintPatterns {
    public static void main(String[] args) {
        int size = 8;
        System.out.println("(a)"); printPatternA(size);
        System.out.println("(b)"); printPatternB(size);
        System.out.println("(c)"); printPatternC(size);
        System.out.println("(d)"); printPatternD(size);
        System.out.println("(e)"); printPatternE(size);
        System.out.println("(f)"); printPatternF(size);
        System.out.println("(g)"); printPatternG(size);
        System.out.println("(h)"); printPatternH(size);
        System.out.println("(i)"); printPatternI(size);
        System.out.println("(j)"); printPatternJ(size);
        System.out.println("(k)"); printPatternK(size);
        System.out.println("(l)"); printPatternL(size);
        System.out.println("(m)"); printPatternM(size);
        System.out.println("(n)"); printPatternN(size);
        System.out.println("(o)"); printPatternO(size);
        System.out.println("(p)"); printPatternP(size);
        System.out.println("(q)"); printPatternQ(size);
        System.out.println("(r)"); printPatternR(size);
        System.out.println("(s)"); printPatternS(size);
        System.out.println("(t)"); printPatternT(size);
        System.out.println("(u)"); printPatternU(size);
    }

    public static void printPatternA(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printPatternB(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row + 1; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printPatternC(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col < row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= size - row + 1; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printPatternD(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void printPatternE(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || col == 1 || col == size) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatternF(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || row == col) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatternG(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || row + col == size + 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatternH(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || row == col || row + col == size + 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatternI(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                if (row == 1 || row == size || col == 1 || col == size || row == col || row + col == size + 1) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printPatternJ(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col < row; col++) System.out.print("  ");
            for (int col = 1; col <= 2 * (size - row) + 1; col++) System.out.print("# ");
            System.out.println();
        }
    }

    public static void printPatternK(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = 1; col <= 2 * row - 1; col++) System.out.print("# ");
            System.out.println();
        }
    }

    public static void printPatternL(int size) {
        // Upper half
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = 1; col <= 2 * row - 1; col++) System.out.print("# ");
            System.out.println();
        }
        // Lower half
        for (int row = size - 1; row >= 1; row--) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = 1; col <= 2 * row - 1; col++) System.out.print("# ");
            System.out.println();
        }
    }

    public static void printPatternM(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternN(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row + 1; col++) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternO(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = row; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternP(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = size - row + 1; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternQ(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            for (int col = row - 1; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternR(int size) {
        for (int row = size; row >= 1; row--) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            for (int col = row - 1; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternS(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            for (int col = 1; col <= 2 * (size - row); col++) System.out.print("  ");
            for (int col = row; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternT(int size) {
        for (int row = size; row >= 1; row--) {
            for (int col = 1; col <= row; col++) System.out.print(col + " ");
            for (int col = 1; col <= 2 * (size - row); col++) System.out.print("  ");
            for (int col = row; col >= 1; col--) System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void printPatternU(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size - row; col++) System.out.print("  ");
            for (int i = 0; i < row; i++) System.out.print((row + i) % 10 + " ");
            for (int i = row - 2; i >= 0; i--) System.out.print((row + i) % 10 + " ");
            System.out.println();
        }
    }
}
