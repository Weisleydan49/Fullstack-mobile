from fastapi import FastAPI, HTTPException
from models import Product
from typing import Optional

app = FastAPI()

@app.get("/")
def greet():
    return "Welcome to FastAPI"

products = [
    Product(id=1, name="Laptop", description="Dell Latitude 7400", price=30000.00, quantity=5),
    Product(id=2, name="Smartphone", description="Pixel 10", price=75000, quantity=2)
]

@app.get("/products")
def get_all_products():
    return products


@app.get("/product/{id}")
def get_product_by_id(id: int):
    for product in products:
        if product.id == id:
            return product
    raise HTTPException(status_code=404, detail="Product not found")
    

@app.post("/product")
def add_product(product: Product):
    products.append(product)
    return product

@app.patch("/product/{id}")
def update_product(id: int, name: Optional[str] = None, description: Optional[str] = None, price: Optional[float] = None, quantity: Optional[int] = None):
    for index, product in enumerate(products):
        if product.id == id:
            if name is not None:
                product.name = name
            if description is not None:
                product.description = description
            if price is not None:
                product.price = price
            if quantity is not None:
                product.quantity = quantity
            products[index] = product
            return product
    raise HTTPException(status_code=404, detail="Product not found")