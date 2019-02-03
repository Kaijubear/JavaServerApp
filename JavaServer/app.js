var net = require('net');

var HOST = '127.0.0.1';
var PORT = 6969;

net.createServer((socket) => {
	console.log('CONNECTED: '+socket.remoteAddress+':'+socket.remotePort);
	
	//add data event handler
	socket.on('data',(data) => {
		//data recieved, write message back
		socket.write(data);
	});
	
	//add close event handler
	socket.on('close', (data) => {
		//close connection
		console.log('CLOSED: '+socket.remoteAddress+':'+socket.remotePort)
	});
	
}).listen(PORT,HOST);

console.log('Server listening on '+HOST+":"+PORT);