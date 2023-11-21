import tkinter as tk
import cv2
from PIL import Image, ImageTk

def play_video():
    video_path = 'Images/video.mp4'  # Replace this with your video file path
    cap = cv2.VideoCapture(video_path)

    window = tk.Tk()
    window.title("Video Player")
    # Get the screen width and height
    screen_width = window.winfo_screenwidth()
    screen_height = window.winfo_screenheight()

    # Calculate the window position to center it on the screen
    window_width = 640  # Set the initial window width
    window_height = 480  # Set the initial window height
    x = (screen_width - window_width) // 2
    y = (screen_height - window_height) // 2

    window.geometry(f"{window_width}x{window_height}+{x}+{y}")  # Set the window size and position

    video_label = tk.Label(window)
    video_label.pack()

    def update_video():
        ret, frame = cap.read()
        if ret:
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            img = ImageTk.PhotoImage(Image.fromarray(frame))
            video_label.img = img
            video_label.config(image=img)
            video_label.after(20, update_video)
        else:
            cap.release()
            window.destroy()

    update_video()
    window.mainloop()

play_video()
