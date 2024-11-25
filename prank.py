import pyautogui as gui
import time
import random
import string


messages = [
    "You make my heart flutter every time I see you.",
    "Your smile brightens even the cloudiest of days.",
    "Being around you feels like a beautiful adventure.",
    "I admire your kindness and genuine nature.",
    "You're the reason my day starts with a smile.",
    "I feel lucky to know someone as incredible as you.",
    "Your presence alone is a gift to everyone around you.",
    "I'm constantly inspired by your passion and drive.",
    "Your laughter is music to my ears.",
    "You have a way of making the ordinary extraordinary.",
    "I cherish every moment we spend together.",
    "Your uniqueness is what makes you so captivating.",
    "You have a heart of gold that shines brightly.",
    "I find myself thinking about you more than I should.",
    "Your intelligence and wit always leave me in awe.",
    "I'm drawn to your authenticity and honesty.",
    "You're more wonderful than words can express.",
    "I appreciate your support and encouragement.",
    "You bring out the best in everyone around you.",
    "My feelings for you grow stronger with each passing day."
]

time.sleep(5)

for i in range(len(messages)):
    random_message = random.choice(messages)
    gui.typewrite(random_message)
    gui.press('Enter')
    time.sleep(1)  # Adding a small delay between messages for readability
