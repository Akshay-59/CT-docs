CREATE SCHEMA PatientAdministration
CREATE TABLE PatientAdministration.Patient
(
	PatientID INT IDENTITY(101,1) PRIMARY KEY,
	PatName VARCHAR(50) NOT NULL,
	DOB DATE CHECK(DOB< GETDATE()),
	IdProofType VARCHAR(20) CHECK(IdProoftype IN ('Aadhar', 'Pancard')),
	IdProofNumber VARCHAR(20),
	Gender VARCHAR(10) CHECK(Gender IN ('MALE', 'FEMALE'))
)

INSERT INTO PatientAdministration.Patient
(PatName, DOB, IdProoftype, IdProofNumber, Gender)
VALUES
('John', '10-Oct-1994', 'Aadhar', '276885680445', 'Male'),
('David', '15-Oct-1992', 'Pancard', 'GFYPS15T', 'Male')

select * from PatientAdministration.Patient

CREATE TABLE PatientAdministration.NextOfKin
(
	KinId INT IDENTITY(101,1) PRIMARY KEY,
	RelativeName VARCHAR(20),
	Relation VARCHAR(20),
	PatientID INT REFERENCES PatientAdministration.Patient(PatientId) NOT NULL
)
INSERT INTO PatientAdministration.NextOfKin
(RelativeName,Relation,PatientID)
VALUES
('James','Father', 101),
('Newton', 'Brother',102 )

SELECT * FROM PatientAdministration.NextOfKin