
    var xmlHttpReq = null;
    
    function sendURL(url) {
        if (xmlHttpReq == null ) {
            if (window.XMLHttpRequest) {
                xmlHttpReq = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        
        if (xmlHttpReq == null) {
            return null;
        }
        
        xmlHttpReq.open("GET", url, false);
        xmlHttpReq.send(null);
        return xmlHttpReq.responseText;
        
    }
        