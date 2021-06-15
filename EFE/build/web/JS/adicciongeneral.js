/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const ANGLE = 45;

let wowpanels = document.querySelectorAll(".wowpanel");
let colors = ['#F6D445', '#63EB4E', '#45E0F6', '#F59500'];

wowpanels.forEach((element, i) => {
	floatable(element, colors[i]);
});

function floatable (panel, color) {
	let content = panel.querySelector(".content");
	content.style.backgroundColor = color;

	panel.addEventListener('mouseout', e => {
		content.style.transform = `perspective(300px)
								   rotateX(0deg)
								   rotateY(0deg)
								   rotateZ(0deg)`;
	});

	panel.addEventListener('mousemove', e => {
		let w = panel.clientWidth;
		let h = panel.clientHeight;
		let y = (e.offsetX - w * 0.5) / w * ANGLE;
		let x = (1 - (e.offsetY - h * 0.5)) / h * ANGLE;

		content.style.transform = `perspective(300px)
								   rotateX(${x}deg)
								   rotateY(${y}deg)`;
	});
}
