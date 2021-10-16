// import "./styles.css";
import ComboBox from "./component/ComboBox";
import Button from "./component/Buttons";

import MaterialSchema from "./component/UI/MaterialSchema";
import AntdSchema from "./component/UI/AntdSchema";
import BootstrapSchema from "./component/UI/BootstrapSchema";
import FluentSchema from "./component/UI/FluentSchema";
import SemanticSchema from "./component/UI/SemanticSchema";

export default function App() {
	const Themes = sessionStorage.getItem("Themes");
	return (
		<div className="App">
			<ComboBox />
			<Button />
			{Themes == "Semantic UI" ? <MaterialSchema /> : <AntdSchema />}
		</div>
	);
}
