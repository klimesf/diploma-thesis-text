import sys

if len(sys.argv) is not 3:
    print("Usage: detex.py source.tex output.txt")

source_filename = sys.argv[1]
output_filename = sys.argv[2]

with open(source_filename, 'r') as source, open(output_filename, 'w') as destination:
    last_empty = False
    result = ""
    for raw_line in source.readlines():
        line = raw_line.strip()
        if line.startswith('\\') or line.startswith('%'): continue
        line = line.replace('\\\'{\i}', "í")
        line = line.replace('\\\'y', "ý")

        if last_empty:
            result += '\n'
            last_empty = False
        else: result += ' '

        if len(line) is 0:
            last_empty = True

        result += line
    destination.write(result)
