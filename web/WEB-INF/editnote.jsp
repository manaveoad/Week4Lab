<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title" value="${title}"><br>
            <label for="contents">Contents:</label>
            <textarea name="contents" rows="5" cols="33" value="${contents}">
                
            </textarea>
            <button type="submit" name="savenote" onclick="">Submit</button>
        </form>
        
    </body>
</html>
