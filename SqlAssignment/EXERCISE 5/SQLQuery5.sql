Use AdventureWorks2008R2
Go
CREATE PROCEDURE GetPersonNameInfo
    @FirstNameFilter NVARCHAR(50) = NULL
AS
BEGIN
    SELECT FirstName, MiddleName, LastName
    FROM Person.Person
    WHERE FirstName LIKE '%' + ISNULL(@FirstNameFilter, '') + '%'
END

EXEC GetPersonNameInfo 'Ken';
