let socket = new WebSocket("ws://192.168.1.130:8080/ws/notifications");
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
	  socketStatus.innerHTML = "Disconnected..."
    } else {
      // e.g. server process killed or network down
      // event.code is usually 1006 in this case
      console.error('[close] Connection died');
	  socketStatus.innerHTML = "Disconnected..."
    }
  };
  
  socket.onerror = function(error) {
    console.error(`[error] ${error.message}`);
  };

clearButton.addEventListener('click', (e) => {
	pedidos.innerHTML = ""
})

disconnect.addEventListener('click', e => {
	socket.close()
})
