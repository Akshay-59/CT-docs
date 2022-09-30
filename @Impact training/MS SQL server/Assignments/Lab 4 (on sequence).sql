/*
Create a seq and insert data into multiple tables from the seq.
**Start with 5 maxvalue 10 minvalue 1 cycle
*/
Create Sequence SeqDemo
Start with 5
Increment By 1
Minvalue 1
Maxvalue 10
Cycle
 INsert into patientVisits(PatientID, VisitPurpose,VisitTime) Values
 (Next value for SeqDemo, 'P',35)

 INsert into patientVisits(PatientID, VisitPurpose,VisitTime) Values
 (Next value for SeqDemo, 'C',25),
  (Next value for SeqDemo, 'R',15),
   (Next value for SeqDemo, 'R',30),
    (Next value for SeqDemo, 'P',40)


Create table  PatientVisits(
VisitID INT  Primary Key IDENTITY(1,1),
PatientID INT , 
VisitPurpose VArchar(5),
VisitTime INT
)

Insert Into PatientVisits VAlues
(101,'C',15),
(999,'P',15),
(101,'R',15),
(222,'C',15),
(222,'C',15),
(101,'P',15),
(222,'R',15),
(888,'R',15),
(777,'P',15),
(999,'R',15)
Select * from PatientVisits
