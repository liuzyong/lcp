import Button from "@mui/material/Button";
import { Button as AntdButton } from "antd";
import "antd/dist/antd.css"; // or 'antd/dist/antd.less'

export default function ButtonTest() {
	const onClick = () => {
		// alert("click");
	};
	return (
		<div>
			<Button variant="contained" color="secondary" onClick={onClick}>
				Mui Button
			</Button>

			<AntdButton type="ghost" onClick={onClick}>
				Antd Button
			</AntdButton>
		</div>
	);
}
