#version 120

uniform mat4 projectionMatrix;
uniform mat4 viewMatrix = mat4(1.0);
uniform mat4 modelMatrix = mat4(1.0);

void main() {
	gl_Position = projectionMatrix * viewMatrix * modelMatrix * gl_Vertex;
	gl_TexCoord[0] = gl_MultiTexCoord0;
}
