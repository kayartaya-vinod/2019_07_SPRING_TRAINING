<%@ include file="header.txt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div class="row">
	<div class="col-sm-2"></div>
	<div class="col">
		<h3>${title}</h3>
		<sf:form modelAttribute="pr" action="add-or-update-product">

			<sf:hidden path="productId" />

			<div class="form-group row">
				<label for="productName" class="col-sm-4 col-form-label">Product
					name</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="productName"
						placeholder="product name" />

					<sf:errors class="text-danger" path="productName" />
				</div>
			</div>

			<div class="form-group row">
				<label for="categoryId" class="col-sm-4 col-form-label">Category
					id</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="categoryId"
						placeholder="category id" />
					<sf:errors class="text-danger" path="categoryId" />
				</div>
			</div>

			<div class="form-group row">
				<label for="supplierId" class="col-sm-4 col-form-label">Supplier
					id</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="supplierId"
						placeholder="supplier id" />
					<sf:errors class="text-danger" path="supplierId" />
				</div>
			</div>

			<div class="form-group row">
				<label for="quantityPerUnit" class="col-sm-4 col-form-label">Quantity
					per unit</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="quantityPerUnit"
						placeholder="quantity per unit" />
					<sf:errors class="text-danger" path="quantityPerUnit" />
				</div>
			</div>

			<div class="form-group row">
				<label for="unitPrice" class="col-sm-4 col-form-label">Unit
					price</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="unitPrice"
						placeholder="unit price" />
					<sf:errors class="text-danger" path="unitPrice" />
				</div>
			</div>

			<div class="form-group row">
				<label for="unitsInStock" class="col-sm-4 col-form-label">Units
					in stock</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="unitsInStock"
						placeholder="units in stock" />
					<sf:errors class="text-danger" path="unitsInStock" />
				</div>
			</div>

			<div class="form-group row">
				<label for="unitsOnOrder" class="col-sm-4 col-form-label">Units
					on order</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="unitsOnOrder"
						placeholder="units on order" />
					<sf:errors class="text-danger" path="unitsOnOrder" />
				</div>
			</div>

			<div class="form-group row">
				<label for="reorderLevel" class="col-sm-4 col-form-label">Reorder
					level</label>
				<div class="col-sm-8">
					<sf:input class="form-control" path="reorderLevel"
						placeholder="reorder level" />
					<sf:errors class="text-danger" path="reorderLevel" />
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Discontinued?</label>
				<div class="col-sm-8">
					<sf:radiobutton path="discontinued" label="Yes" value="1" />
					<sf:radiobutton path="discontinued" label="No" value="0" />
				</div>
			</div>


			<button class="btn btn-primary">Save details</button>
		</sf:form>

	</div>
	<div class="col-sm-2"></div>
</div>
<%@ include file="footer.txt"%>