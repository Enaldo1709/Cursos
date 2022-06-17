let socket = new WebSocket("ws://localhost:8080/ws/notifications");
let pedidos = document.getElementById("pedidos")

socket.onopen = function(e) {
    console.log("Connected to socket...")
};
  
  socket.onmessage = function(event) {
    pedidos.innerHTML = pedidos.innerHTML + `<p>${event.data}</p>`
    console.log(`[message] Data received from server: ${event.data}`);
  };
  
  socket.onclose = function(event) {
    if (event.wasClean) {
      alert(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
    } else {
      // e.g. server process killed or network down
      // event.code is usually 1006 in this case
      alert('[close] Connection died');
    }
  };
  
  socket.onerror = function(error) {
    console.error(`[error] ${error.message}`);
  };
