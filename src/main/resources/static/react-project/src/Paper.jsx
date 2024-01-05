import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import "./App.css";
export default function BackgroundMenu() {
  return (
    <Box
      sx={{
        "& > :not(style)": {
          m: 1,
          width: 600,
          height: 300,
        },
      }}
    >
      <Paper
        style={{
          position: "relative",
          display: "flex",
          left: "390px",
          top: "149px",
          borderRadius: "50px",
        }}
        elevation={3}
      />
    </Box>
  );
}
