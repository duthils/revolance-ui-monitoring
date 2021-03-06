<%@ include file="Header.jsp" %>

    <div class="container">
        <div class="row">
            <div class="page-title">
                <h2>Exploration List</h2>
            </div>
            <div class="page-toolbar">
                <a href="${pageContext.request.contextPath}/explorations/declare"><button class="btn" id="add">Add</button></a>
                <a href="#"><button class="btn" id="del" disabled>Remove</button></a>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>&nbsp;&nbsp;</th>
                        <th>Tag</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tag" items="${tags}">
                        <tr>
                            <td><input type="checkbox"></td>
                            <td><div class="tag"><a href="${pageContext.request.contextPath}/explorations/${tag}">${tag}</a></div></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/exploration-list.js"></script>

<%@ include file="Footer.jsp" %>