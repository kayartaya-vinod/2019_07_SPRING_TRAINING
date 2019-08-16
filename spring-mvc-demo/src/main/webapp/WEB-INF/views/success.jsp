<%@ include file="header.txt"%>

<h3 class="alert alert-success">Hooray! product details added
	successfully!</h3>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col">

		<div class="form-group row">
			<label for="staticEmail" class="col-sm-4 col-form-label">Product
				name</label>
			<div class="col-sm-8">${pr.productName}</div>
		</div>

		<div class="form-group row">
			<label for="staticEmail" class="col-sm-4 col-form-label">Quantity
				per unit</label>
			<div class="col-sm-8">${pr.quantityPerUnit}</div>
		</div>

		<div class="form-group row">
			<label for="staticEmail" class="col-sm-4 col-form-label">Unit
				price</label>
			<div class="col-sm-8">${pr.unitPrice}</div>
		</div>

		<div class="form-group row">
			<label for="staticEmail" class="col-sm-4 col-form-label">Units
				in stock</label>
			<div class="col-sm-8">${pr.unitsInStock}</div>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>



<%@ include file="footer.txt"%>
