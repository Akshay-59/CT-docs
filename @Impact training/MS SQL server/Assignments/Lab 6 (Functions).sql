--LAB on Functions:: Insert prime numbers from 1 to 1000 in a table. Create a function to check if a number is prime or not
Create schema numbers
Create Table numbers.Prime(
Numbers INT
)
Insert into numbers.Prime values()


Select *(
Create function isPrime (@number int) 
returns int  as 
Begin
	Declare @result bit = 1,@i int = 2
	While (@i<@number)
	Begin
		if(@number % @i = 0)
		Begin
			Set @result = 0
			break
		End
		Set @i += 1
	End
	return @result
End
) From PrimeNumbers


Select dbo.isPrime(67)
Select dbo.isPrime(7)
----------------------------------------------------------