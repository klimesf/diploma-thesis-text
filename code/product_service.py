from flask import Flask, jsonify
from model import ProductRepository

app = Flask(__name__)
product_repository = ProductRepository()

@app.route("/")
def list_all_products():
    result = []
    for product in product_repository.get_all():
        result.append({
            'id': product.id,
            'sellPrice': product.sellPrice,
            'name': product.name,
            'description': product.description
        })
    return jsonify(result)
