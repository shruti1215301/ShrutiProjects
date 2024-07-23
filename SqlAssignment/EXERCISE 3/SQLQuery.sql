USE AdventureWorks2008R2
GO

--Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks.
SELECT TOP(5) SalesOrderID, TotalDue, AccountNumber
FROM Sales.SalesOrderHeader
WHERE SalesOrderHeader.TotalDue>70000
