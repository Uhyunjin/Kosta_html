<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//사용자가 요청한 문자셋은 한글입니다.
	request.setCharacterEncoding("UTF-8");
	//사용자 요청한 고객의 이름을 받아옵니다.
	String name=request.getParameter("name");	// form에서 받아오는 name과 이름을 일치시켜야한다.
	%>
    <h2><%=name%> 고객의 주문도서 목록</h2>
    <hr>
    <table border="1" width="80%">
        <thead>
        <tr>
            <th>도서번호</th>
            <th>도서명</th>
            <th>가격</th>
            <th>출판사</th>
        </tr>
        </thead>
        <%
            try {
                String driver="oracle.jdbc.driver.OracleDriver";
                String url="jdbc:oracle:thin:@localhost:1521:XE";
                String username="c##madang";
                String password="madang";
                String sql="SELECT bookid,bookname,price,publisher " +
                        "FROM BOOK " +
                        "WHERE BOOKID IN (SELECT bookid FROM ORDERS o " +
                        "WHERE custid=(SELECT custid FROM CUSTOMER c WHERE name='"+name+"'))";
                // 1.jdbc드라이버를 메모리로 로드한다
                Class.forName(driver);
                // 2.DB서버에 연결한다
                Connection conn = DriverManager.getConnection(url,username,password);

                // 3.Statement객체를 생성한다
                Statement stmt=conn.createStatement();

                // 4.sql명령을 실행한다.
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next()){
            %>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                </tr>
            <%
                }
           	}catch (Exception e){
               System.out.println(e.getMessage());
            }
            %>
    </table>
</body>
</html>