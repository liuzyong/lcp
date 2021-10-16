import React, { useEffect } from "react";
import { connect } from 'dva';
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";

import MaterialSchema from "./UI/MaterialSchema";
import AntdSchema from "./UI/AntdSchema";
import BootstrapSchema from "./UI/BootstrapSchema";
import FluentSchema from "./UI/FluentSchema";
// import SemanticSchema from "./component/UI/SemanticSchema";

//支持多个UI风格切换
const SchemaUI = (props) => {
	const { dispatch, themes } = props;
	const onInputChange = (event, newValue) => {
		dispatch({
			type: 'themes/saveThemes',
			payload: newValue,
		});
	};

	useEffect(() => {
	});

	return (
		<div>
			<div>
				<Autocomplete
					inputValue={themes.uiSchema}
					// 必须是两个参数 event不能省略
					onInputChange={onInputChange}
					disablePortal
					id="combo-box-demo"
					options={ThemesList}
					// sx={{ width: 300 }}
					renderInput={(params) => (
						<TextField {...params} label="Select themes" variant="standard" />
					)}
				/>
			</div>
			{
				themes.uiSchema == "Material-ui" ? <MaterialSchema />
					: themes.uiSchema == "Antd" ? <AntdSchema />
						: themes.uiSchema == "Fluent-ui" ? <FluentSchema />
							: themes.uiSchema == "Bootstrap 4" ? <BootstrapSchema />
								// : Themes == "Semantic UI" ? <SemanticSchema />
								: <MaterialSchema />
			}
		</div>
	);

};

const ThemesList = [
	{ label: "Material-ui" },
	{ label: "Antd" },
	{ label: "Fluent-ui" },
	{ label: "Bootstrap 4" },
	{ label: "Semantic UI" }
];


const mapStateToProps = ({ global, themes }) => ({ global, themes: themes })
export default connect(mapStateToProps)(SchemaUI);
