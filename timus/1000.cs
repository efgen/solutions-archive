using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] a = Console.ReadLine().Split(' ');
            int r = int.Parse(a[0]) + int.Parse(a[1]);
            Console.WriteLine(r.ToString());
        }
    }
}
