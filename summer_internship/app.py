import pandas as pd
import os

# int_connect = input("enter how is internet , good or bad ")

files_dir = str(os.path.dirname(os.path.realpath(__file__)))


file_paths = [os.path.join(files_dir, file_name) for file_name in os.listdir(files_dir)]
file_sizes = [os.path.getsize(file_path) for file_path in file_paths]

df = pd.DataFrame({'file_path': file_paths, 'file_size': file_sizes}).sort_values('file_size', ascending = False )

a = df["file_path"]

print(a[::-1])

if int_connect == "good":
    
