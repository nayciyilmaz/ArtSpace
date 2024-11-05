## Features

Modern UI Design: Clean, minimalist design created with Jetpack Compose and Material Design 3 components.
Dynamic Art Display: Displays a rotating selection of artworks with artist information and creation year.
Interactive Navigation: "Previous" and "Next" buttons allow users to seamlessly navigate through different artworks.
Custom Styling: Customizable backgrounds, shadows, and borders enhance the visual appeal of the displayed art pieces.

## Project Structure

MainActivity.kt: The main activity that initializes the app, sets the theme, and loads the main ArtSpaceLayout composable.
ArtSpaceLayout(): Composable function that organizes the layout, including the art image, details section, and navigation buttons.
EditTextField(): A text composable with configurable font size and boldness, used for artist and year information.
EditImageField(): Composable to display the artwork image with customizable size and border.

## Technologies Used

Kotlin: Used as the primary language for building this Android app.
Jetpack Compose: For building the entire UI declaratively.
Material Design 3: Ensures a visually consistent and accessible user interface.
State Management: Used mutableIntStateOf and remember for managing image and text states within the composable layout.
