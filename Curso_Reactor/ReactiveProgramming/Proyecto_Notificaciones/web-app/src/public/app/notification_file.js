let socket = new WebSocket("ws://localhost:8080/ws/notifications");
let pedidos = document.getElementById("pedidos")
let clearButton = document.getElementById("clear")
let socketStatus = document.getElementById("socket-status")
let disconnect = document.getElementById("disconnect")


socket.onopen = function(e) {
    socketStatus.innerHTML = "Connected to server..."
};
  
  socket.onmessage = function(event) {
    pedidos.innerHTML = pedidos.innerHTML + `<p>${event.data}</p>`
    console.log(`[message] Data received from server: ${event.data}`);
  };
  
  socket.onclose = function(event) {
    if (event.wasClean) {
      console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
    } else {
      // e.g. server process killed or network down
      // event.code is usually 1006 in this case
      console.error('[close] Connection died');
    }
  };
  
  socket.onerror = function(error) {
    console.error(`[error] ${error.message}`);
  };

clearButton.addEventListener('click', (e) => {
	pedidos.innerHTML = ""
})

disconnect.addEventListener('click', e => {
	socketStatus.innerHTML = "Disconnected..."
	socket.close()
})
