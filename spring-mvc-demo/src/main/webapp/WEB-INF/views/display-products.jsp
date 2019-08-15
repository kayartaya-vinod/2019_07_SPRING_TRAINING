<%@ include file="./header.txt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Product list</h3>
<table class="table table-striped table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th>Name</th>
			<th>Unit price</th>
			<th>Quantity per unit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.productName}</td>
				<td>${p.unitPrice}</td>
				<td>${p.quantityPerUnit}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="./footer.txt"%>
