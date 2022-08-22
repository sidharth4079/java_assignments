package BankInterest;

class DifferenceOfDate
{

	static class Date
	{
		int d, m, y;

		public Date(int d, int m, int y)
		{
			this.d = d;
			this.m = m;
			this.y = y;
		}

	};

	
	static int monthDays[] = {31, 28, 31, 30, 31, 30,
							31, 31, 30, 31, 30, 31};

	
	static int countLeapYears(Date d)
	{
		int years = d.y;

		
		if (d.m <= 2)
		{
			years--;
		}

		
		return years / 4 - years / 100 + years / 400;
	}

	
	static int getDifference(Date dt1, Date dt2)
	{
		
		int n1 = dt1.y * 365 + dt1.d;

		
		for (int i = 0; i < dt1.m - 1; i++)
		{
			n1 += monthDays[i];
		}

		n1 += countLeapYears(dt1);

		int n2 = dt2.y * 365 + dt2.d;
		for (int i = 0; i < dt2.m - 1; i++)
		{
			n2 += monthDays[i];
		}
		n2 += countLeapYears(dt2);

		return (n2 - n1);
	}

	
	static public int getDiff(String currentDate, String previousDate) {
		String[] currentDate1 = currentDate.split("/");
	
		int[] currentDate2 = {Integer.valueOf(currentDate1[0]), Integer.valueOf(currentDate1[1]), Integer.valueOf(currentDate1[2])};
		String[] previousDate1 = previousDate.split("/");
		
		int[] previousDate2 = {Integer.valueOf(previousDate1[0]), Integer.valueOf(previousDate1[1]), Integer.valueOf(previousDate1[2])};
		
	
		Date dt1 = new Date(currentDate2[0], currentDate2[1], currentDate2[2]);
		Date dt2 = new Date(previousDate2[0], previousDate2[1],previousDate2[2]);
		return getDifference(dt1, dt2);
		
	}
	public static void main(String[] args)
	{
		Date dt1 = new Date(1, 2, 2004);
		Date dt2 = new Date(2, 2, 2004);
		System.out.println("Difference between two dates is " +
							getDiff("1/2/2004", "2/2/2004"));
	}
}

