
public class Gallows {
    private int count;
    private final static char[] elementsGallows = new char[]{111, 92, 47, 124, 47, 92};
    private final static String[][] elements = new String[7][8];

    public Gallows(){
        createGallows();
    }
    public Gallows(int count) {
        this.count = count;
        addElementGallows();
    }

    private static void putEmptyGallows(){
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < 8; j++) {
                elements[i][j] = " ";
            }
        }
    }

    private static void createGallows(){
         putEmptyGallows();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 7; j++) {
                elements[i][j] = Character.toString((char)95);
            }
        }
        for (int i = 6; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                elements[i][j] = Character.toString((char)45);
            }
        }
        for (int i = 1; i < 6; i++) {
            elements[i][6] = Character.toString((char)124);
        }
        elements[1][1] = Character.toString((char)124);;
    }

    private void addElementGallows(){
        switch (count){
            case 1:
                elements[2][1] = Character.toString(elementsGallows[0]);
                break;
            case 2:
                elements[2][0] = Character.toString(elementsGallows[1]);
                break;
            case 3:
                elements[2][2] = Character.toString(elementsGallows[2]);
                break;
            case 4:
                elements[3][1] = Character.toString(elementsGallows[3]);
                break;
            case 5:
                elements[4][0] = Character.toString(elementsGallows[4]);
                break;
            case 6:
                elements[4][2] = Character.toString(elementsGallows[5]);
                break;
            default:break;
        }
    }

    public void outGallows(){
        for (String[] element : elements) {
            for (int j = 0; j < 8; j++) {
                System.out.print(element[j]);
            }
            System.out.println();
        }
    }

}
