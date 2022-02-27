<%--  
Author(s): Dalvir Singh Chiount (A01258927)
--%>

<html>
<head>
<%@page import="ca.bcit.comp3601.DatabaseQuery"%>
<%@page import="ca.bcit.comp3601.Customer"%>
<%@page import="java.util.ArrayList"%>

<meta charset="utf-8">
<title>Assignment 02</title>
<link href="minimal-table.css" rel="stylesheet" type="text/css">
<style>
table, th, td {
	border-style: groove;
	border-collapse: collapse;
	background-color: #D6EE10;
}

td {
	text-align: center;
}
</style>

</head>
<body>
	<h1>Members</h1>
	<form method ="post">

		<table>
			<tr>
				<th style="white-space: nowrap">Member ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Code</th>
				<th>Country</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th colspan="2">Action</th>
			</tr>

			<%
			DatabaseQuery database = (DatabaseQuery) request.getAttribute("database");
			ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
			int index = 0;
			for (Customer customer : customers) {
			%>

			<tr>
				<td style="white-space: nowrap"><input type="text"
					name="memberId_<%=index%>" value="<%=customer.getMemberId()%>"
					readonly /></td>
				<td style="white-space: nowrap"><input type="text"
					name="firtName_<%=index%>" value="<%=customer.getFirstName()%>" /></td>
				<td><input type="text" name="lastName_<%=index%>"
					value="<%=customer.getLastName()%>" /></td>
				<td><input type="text" name="address_<%=index%>"
					value="<%=customer.getAddress()%>" /></td>
				<td><input type="text" name="city_<%=index%>"
					value="<%=customer.getCity()%>" /></td>
				<td><input type="text" name="code_<%=index%>"
					value="<%=customer.getCode()%>" /></td>
				<td><input type="text" name="country_<%=index%>"
					value="<%=customer.getCountry()%>" /></td>
				<td><input type="text" name="phone_<%=index%>"
					value="<%=customer.getPhoneNumber()%>" /></td>
				<td><input type="text" name="email_<%=index%>"
					value="<%=customer.getEmail()%>" /></td>
				<td><button type="submit" name="update_<%=index%>">Update</button></td>
				<td><button type="submit" name="delete_<%=index%>">Delete</button></td>
				<%
				if (request.getParameter(String.format("update_" + index)) != null) {

					int id = Integer.parseInt(request.getParameter(String.format("memberId_" + index)));
					String firstName = request.getParameter(String.format("firtName_" + index));
					String lastName = request.getParameter(String.format("lastName_" + index));
					String address = request.getParameter(String.format("address_" + index));
					String city = request.getParameter(String.format("city_" + index));
					String code = request.getParameter(String.format("code_" + index));
					String country = request.getParameter(String.format("country_" + index));
					String phone = request.getParameter(String.format("phone_" + index));
					String email = request.getParameter(String.format("email_" + index));

					Customer cust = new Customer(id, firstName, lastName, address, city, code, country, phone, email);
					database.update(cust);
					response.setHeader("REFRESH", "0");
				} else if (request.getParameter(String.format("delete_" + index)) != null) {
					database.delete(Integer.parseInt(request.getParameter(String.format("memberId_" + index))));
					response.setHeader("REFRESH", "0");
				}
				%>

			</tr>
			<%
			index++;
			}
			%>
			<tr>

				<td>Auto-fill</td>
				<td><input type="text" name="enterFirtName" /></td>
				<td><input type="text" name="enterLastName" /></td>
				<td><input type="text" name="enterAddress" /></td>
				<td><input type="text" name="enterCity" /></td>
				<td><input type="text" name="enterCode" /></td>
				<td><input type="text" name="enterCountry" /></td>
				<td><input type="text" name="enterPhone" /></td>
				<td><input type="text" name="enterEmail" /></td>

				<td><button type="submit" name="insert">Insert</button></td>
				<td><button
						onclick="document.getElementById('enterFirtName').value = ''">Clear</button></td>
				<%
				if (request.getParameter("insert") != null) {

					int enterId = customers.size() + 1;
					String enterFirtName = request.getParameter("enterFirtName");
					String enterLastName = request.getParameter("enterLastName");
					String enterAddress = request.getParameter("enterAddress");
					String enterCity = request.getParameter("enterCity");
					String enterCode = request.getParameter("enterCode");
					String enterCountry = request.getParameter("enterCountry");
					String enterPhone = request.getParameter("enterPhone");
					String enterEmail = request.getParameter("enterEmail");
					Customer cust = new Customer(enterId, enterFirtName, enterLastName, enterAddress, enterCity, enterCode,
					enterCountry, enterPhone, enterEmail);
					try {
						database.add(cust);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					response.setHeader("REFRESH", "0");
				}
				%>

			</tr>

		</table>
	</form>
</body>
</html>
<!--<c:forEach var="member" items="${members}">
		</c:forEach>-->