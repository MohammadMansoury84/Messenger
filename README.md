<h1 align="center">💬 Messenger Application</h1>

<h3 align="center">
A Java-Based Client-Server Chat Application
</h3>

<p align="center">
A real-time desktop messenger application built with Java and JavaFX,
implementing socket-based communication, multi-client handling,
and interactive chat features.
</p>

<p align="center">
<img src="screenshots/banner.png" width="800">
</p>


<h2>🚀 About The Project</h2>

<p>
<strong>Messenger</strong> is a desktop chat application developed using
<strong>Java</strong> that demonstrates the implementation of a
real-time client-server communication system.
</p>

<p>
The application uses TCP socket programming to establish communication
between multiple clients and a central server. Each connected user can
send and receive messages instantly through an interactive graphical user
interface developed with JavaFX.
</p>

<p>
This project focuses on understanding fundamental concepts of:
</p>

<ul>
<li>Client-Server Architecture</li>
<li>Network Programming</li>
<li>Socket Communication</li>
<li>Multithreading</li>
<li>JavaFX GUI Development</li>
<li>Object-Oriented Programming</li>
</ul>


<h2>✨ Features</h2>


<h3>🔐 User Interface & Login</h3>

<ul>
<li>User login system</li>
<li>Username-based identification</li>
<li>Interactive JavaFX interface</li>
<li>Error handling for invalid input</li>
</ul>


<h3>💬 Real-Time Messaging</h3>

<ul>
<li>Instant message transmission between connected users</li>
<li>Real-time message receiving</li>
<li>Multiple users communication</li>
<li>Chat history synchronization when joining</li>
</ul>


<h3>👥 Multi Client Server</h3>

<p>
The server is designed to support multiple clients simultaneously.
Each client connection is managed using a dedicated thread.
</p>

<ul>
<li>Dynamic client connection management</li>
<li>Broadcast messages to other users</li>
<li>Track connected users</li>
<li>Handle user disconnection</li>
</ul>


<h3>📩 Private Messaging</h3>

<ul>
<li>Private chat requests between users</li>
<li>User identification using client IDs</li>
<li>Separate private communication channel</li>
</ul>


<h3>🎨 Modern UI Design</h3>

<ul>
<li>JavaFX based graphical interface</li>
<li>FXML layout design</li>
<li>Dark theme interface</li>
<li>Custom styled components</li>
</ul>


<h2>🛠️ Technologies Used</h2>


<p align="left">

<a>
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"
width="50" height="50"/>
</a>

</p>


<ul>
<li>Java</li>
<li>JavaFX</li>
<li>FXML</li>
<li>Socket Programming</li>
<li>Multithreading</li>
<li>Object-Oriented Programming</li>
</ul>


<h2>🏗️ Project Architecture</h2>


<pre>

Messenger

│
├── Client
│
│   ├── ChatApplication.java
│   ├── LoginController.java
│   ├── ChatController.java
│   │
│   └── Resources
│       ├── login-view.fxml
│       └── chat-view.fxml
│
│
└── Server
    │
    ├── Server.java
    ├── ServerCommunication.java
    └── Main.java

</pre>


<h2>⚙️ How It Works</h2>


<p>
The application follows a client-server communication model:
</p>


<ol>

<li>
The server starts and listens on port <strong>1234</strong>.
</li>

<li>
Clients connect to the server using TCP sockets.
</li>

<li>
Each client receives a dedicated communication thread.
</li>

<li>
Messages are received, processed, and forwarded to other users.
</li>

<li>
Disconnected users are automatically removed from the server.
</li>

</ol>


<h2>▶️ How To Run</h2>


<h3>Requirements</h3>

<ul>
<li>Java JDK 17+</li>
<li>JavaFX SDK</li>
<li>IntelliJ IDEA recommended</li>
</ul>


<h3>Run Server</h3>

<pre>
Run:

server/src/Main.java
</pre>


<h3>Run Client</h3>

<pre>
Run:

client/src/main/java/org/example/demo13/ChatApplication.java
</pre>


<h2>👨‍💻 Developer</h2>

<p>
<strong>Mohammad Mansouri</strong>
</p>


<p>
🐙 GitHub:
<a href="https://github.com/MohammadMansoury84">
MohammadMansoury84
</a>
</p>


<h3 align="center">
⭐ If you like this project, consider giving it a star!
</h3>
