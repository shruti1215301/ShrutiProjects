USE AdventureWorks2008R2
Go

CREATE TRIGGER trg_ListPrice
ON Production.Product
AFTER UPDATE
AS
BEGIN
  IF UPDATE(ListPrice)
  BEGIN
    DECLARE @maxIncrease DECIMAL(10,2) = 1.15;
    IF EXISTS (SELECT *
               FROM inserted i
               JOIN deleted d ON i.ProductID = d.ProductID
               WHERE i.ListPrice > d.ListPrice * @maxIncrease)
    BEGIN
      RAISERROR('ListPrice cannot be raised by more than 15 percent in a single change.', 16, 1);
      ROLLBACK TRANSACTION;
    END;
  END;
END;


GO
SELECT * FROM Production.Product;
UPDATE Production.Product
SET ListPrice = 14
WHERE ProductID = 1;
