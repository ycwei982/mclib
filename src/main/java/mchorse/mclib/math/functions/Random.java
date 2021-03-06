package mchorse.mclib.math.functions;

import mchorse.mclib.math.IValue;

public class Random extends Function
{
    public java.util.Random random;

    public Random(IValue[] values) throws Exception
    {
        super(values);

        this.random = new java.util.Random();
    }

    @Override
    public double get()
    {
        double random = 0;

        if (this.args.length >= 3)
        {
            this.random.setSeed((long) this.getArg(2));
            random = this.random.nextDouble();
        }
        else
        {
            random = Math.random();
        }

        if (this.args.length >= 2)
        {
            double a = this.getArg(0);
            double b = this.getArg(1);

            double min = Math.min(a, b);
            double max = Math.max(a, b);

            random = random * (max - min) + min;
        }
        else if (this.args.length >= 1)
        {
            random = random * this.getArg(0);
        }

        return random;
    }

    @Override
    public String getName()
    {
        return "random";
    }
}