USE AdventureWorks2008R2
GO

--USING JOIN
SELECT DISTINCT P.BusinessEntityID, P.LastName, P.MiddleName, P.FirstName
FROM Person.Person P
LEFT JOIN Sales.Customer C
 ON P.BusinessEntityID = C.PersonID
LEFT JOIN Sales.SalesOrderHeader H
 ON C.CustomerID = H.CustomerID
WHERE H.SalesOrderID IS NULL


--USING SUBQUERY
SELECT DISTINCT P.BusinessEntityID, P.LastName, P.MiddleName, P.FirstName
FROM Person.Person P
WHERE P.BusinessEntityID NOT IN (
 SELECT C.PersonID
 FROM Sales.Customer C
 JOIN Sales.SalesOrderHeader H
 ON C.CustomerID = H.CustomerID
 );

--USING CTE
WITH ActiveCustomers (BusinessEntityID)
AS (
 SELECT DISTINCT C.PersonID
 FROM Sales.Customer C
 JOIN Sales.SalesOrderHeader H
 ON C.CustomerID = H.CustomerID
)
SELECT DISTINCT P.BusinessEntityID, P.LastName, P.MiddleName, P.FirstName
FROM Person.Person P
LEFT JOIN ActiveCustomers A
 ON A.BusinessEntityID = P.BusinessEntityID
WHERE A.BusinessEntityID IS NULL;


--USING EXISTS
SELECT DISTINCT P.BusinessEntityID, P.LastName, P.MiddleName, P.FirstName
FROM Person.Person P
WHERE NOT EXISTS (
 SELECT *
 FROM Sales.Customer C
 JOIN Sales.SalesOrderHeader H
 ON C.CustomerID = H.CustomerID
 WHERE C.PersonID = P.BusinessEntityID
 );