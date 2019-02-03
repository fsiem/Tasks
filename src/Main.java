public class Main {

    public static void main(String[] args) {

        // Find max difference
        Integer[] tab= {1,2,3,4,5};

        System.out.println("Largest difference in tab: " + maxDifference(tab));

        // Integer to 8bit binary
        integerToBinary(8);

        // Integer to 8bit binary with loop
        integerToBinaryWithLoop(9);

        // 8bit binary to integer
        binaryToInteger("00000001");

        binaryToIntegerWithLoop("11111000");

        // Find val in BST
        Node n = new Node(20);
        Node n2 = new Node(35);
        Node n3 = new Node(45);
        Node n4 = new Node(55);
        Node n5 = new Node(n2, n, 30);
        Node n6 = new Node(n4, n3,50);
        Node n7 = new Node(n6, n5, 40);


        System.out.println(findVal(n7, 40) == 1 ? "Fant match i BST!" : "Fant ikke match i BST");
    }

    public static class Node {
        public Node right;
        public Node left;
        public int val;

        public Node (Node right, Node left, int val) {
            this.right = right;
            this.left = left;
            this.val = val;
        }

        public Node (int val) {
            this.val = val;
        }
    }

    public static void binaryToInteger(String binary) {
        Integer i = Integer.parseInt(binary,2);
        System.out.println("Integer value of binary " + binary + " : " + i);
    }

    public static void binaryToIntegerWithLoop(String binary) {
        int sum = 0;
        for(int i=binary.length() - 1; i>=4; i--) {
            if(binary.charAt(i) == '1')
                sum += Math.pow(2, binary.length() - 1 - i);
        }

        System.out.println("Integer value of binary " + binary + " with for loop: " + sum);
    }

    public static void integerToBinary(int num) {
        String s = Integer.toString(num, 2);

        String eightBit = transformTo8Bit(s);

        System.out.println("Binary value og integer " + num + " : " + eightBit);
    }

    public static void integerToBinaryWithLoop(int num) {
        int originalNum = num;
        int[] binary = new int[8];
        int i = 0;

        while(num != 0) {
            binary[i] = num % 2;
            num = num/2;
            i++;
        }

        String fourBit = "";
        for (int j = i - 1; j >= 0; j--)
            fourBit += binary[j];

        String eightBit = transformTo8Bit(fourBit);

        System.out.println("Binary value of integer " + originalNum + " with loops : " + eightBit);
}


    public static int maxDifference(Integer[] tab) {
        int minInt = tab[0];
        int maxDiff = 0;

        for (int i = 1; i < tab.length; i++) {
            minInt = Math.min(minInt, tab[i]);
            maxDiff = Math.max(maxDiff, tab[i] - minInt);
        }
        return maxDiff;
    }

    public static int findVal(Node node, int val) {

        if(node == null)
            return 0;

        if(node.val == val) {
            return 1;
        }

        if(node.val > val)
            findVal(node.left, val);

        return findVal(node.right, val);
    }

    // Help methods

    public static String transformTo8Bit(String s) {
        String fourBit = "";

        for(int i=0; i< (4 - s.length()); i++) {
            fourBit += "0";
        }

        fourBit += s;

        char c = fourBit.charAt(0);

        String eightBit = "";

        for(int i=0; i< (8 - fourBit.length()); i++) {
            eightBit += c;
        }

        eightBit += fourBit;

        return eightBit;
    }
}
