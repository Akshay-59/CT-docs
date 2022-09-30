
--Lab
--Register new bank account using stored procedure in the below table
/*
Table: AccountTypeMaster
	.AccountTypeID
	.AccountType (SAVING, CURRENT)

Table: BankAccount
	.AccountID PK IDENTITY
	.AccountType 
	.ConsumerName 
	.BalanceAmount
	.ModifiedDate
*/
--Consider the below rules while registering a bank account
/*
1. Every Account must have minimum balance of Rs. 10000
2. Only account types available in AccountTypeMaster are allowed while registeration
3. ModifiedDate must be not a future date
4. CustomerName must not be alphanumeric
*/

Create Schema Bank
Create table Bank.Accounttypemaster(
AccounttypeId int primary key identity (1500,1),
Accounttype varchar(50) Not null check(Accounttype In ('Savings','Current')),
)
Register new bank account using stored procedure in the below table
dDate

Create Table Bank.BankAccount (
BankAccountId int Primary key identity(1500,1),
AccounttypeId int,
Foreign Key (AccounttypeId) References Bank.Accounttypemaster(AccounttypeId),
ConsumerName Varchar(50),
BalanceAmount decimal,
ModifiedDate Date
)
Alter Procedure RegisterBankAccount
@AccounttypeID int,
@ConsumerName varchar(50),
@BalanceAmount Decimal,
@ModifiedDate Date
As
Begin
if Not exists (Select * from Bank.Accounttypemaster where AccounttypeId = @AccounttypeID)
begin
raiserror('Account type not found',1,1)
return
Endif (@BalanceAmount < 10000)
begin
raiserror('Balance should be Greater that 10000 while Registering',1,1)
Return
Endif(@ModifiedDate > GETDATE())
begin
raiserror('Modified date should not be future date',1,1)
Return
Endif (@ConsumerName Like '%[^a-z][^A-Z][^0-9]%')
begin
raiserror('Consumer Name should not be Alpha Numeric',1,1)
Return
EndInsert into Bank.BankAccount (AccounttypeID,ConsumerName,BalanceAmount,ModifiedDate)
values(@AccounttypeID,@ConsumerName,@BalanceAmount,@ModifiedDate)
EndExec RegisterBankAccount 1500,'test',16000,'2022-05-24'
select * from Bank.BankAccount