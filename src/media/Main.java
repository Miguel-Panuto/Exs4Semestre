package media;

public class Main
{
    public static void main(String[] args)
    {
        double[] n = new double[3];
        for (int i = 0; i < n.length; i++)
        {
            n[i] = MatClass.takeNumber(i);
        }
        double notaFinal = MatClass.media(n);
        MatClass.apareceOsBaguiNaTela(notaFinal);
    }
}
